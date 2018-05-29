package xyz.liweichao.auth.core.code.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import xyz.liweichao.auth.core.code.ValidateCodeException;
import xyz.liweichao.auth.core.code.repository.ValidateCodeRepository;

import java.text.MessageFormat;
import java.util.Map;


/**
 * 抽象的图片验证码处理器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Autowired
    private ValidateCodeRepository validateCodeRepository;

    @Override
    public void create(ServletWebRequest request) {
        C validateCode = generate(request);
        save(request, validateCode);

        send(request, validateCode);
    }

    /**
     * 生成校验码
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public C generate(ServletWebRequest request) {
        String type = getValidateCodeType().toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException(1, MessageFormat.format("验证码生成器{0}不存在。", generatorName));
        }
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 保存校验码
     *
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, C validateCode) {
        ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
        validateCodeRepository.save(getUniqueKey(request), code, getValidateCodeType());
    }

    /**
     * 发送校验码，由子类实现
     *
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode);

    @SuppressWarnings("unchecked")
    @Override
    public void validate(ServletWebRequest request) {

        ValidateCodeType codeType = getValidateCodeType();

        C c = (C) validateCodeRepository.get(getUniqueKey(request), getValidateCodeType());

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), codeType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException(2, "request 请求中获取验证码参数失败！");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(3, MessageFormat.format("{0} :验证码的值不能为空", codeType));
        }

        if (c == null) {
            throw new ValidateCodeException(4, MessageFormat.format("{0} :验证码不存在", codeType));
        }

        if (c.isExpried()) {
            validateCodeRepository.remove(getUniqueKey(request), getValidateCodeType());
            throw new ValidateCodeException(5, MessageFormat.format("{0} :验证码已过期", codeType));
        }

        if (!StringUtils.equals(c.getCode(), codeInRequest)) {
            throw new ValidateCodeException(6, MessageFormat.format("{0} :验证码不匹配", codeType));
        }

        validateCodeRepository.remove(getUniqueKey(request), getValidateCodeType());

    }

    /**
     * 根据请求的url获取校验码的类型
     *
     * @return
     */
    protected ValidateCodeType getValidateCodeType() {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }


    /**
     * 根据请求的url获取校验码的类型
     *
     * @param request
     * @return
     */
    protected String getUniqueKey(ServletWebRequest request) {
        String result = "";
        try {
            result = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "unique");
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException(2, "request 请求中获取验证码参数失败！");
        }
        return result;
    }

}
