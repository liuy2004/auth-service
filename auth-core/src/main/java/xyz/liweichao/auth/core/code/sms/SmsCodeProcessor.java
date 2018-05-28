package xyz.liweichao.auth.core.code.sms;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import xyz.liweichao.auth.core.code.base.AbstractValidateCodeProcessor;
import xyz.liweichao.auth.core.code.base.ValidateCode;
import xyz.liweichao.auth.core.code.base.ValidateCodeGenerator;
import xyz.liweichao.auth.core.code.repository.RedisValidateCodeRepository;
import xyz.liweichao.auth.core.exception.AuthException;
import xyz.liweichao.auth.core.properties.SecurityConstants;
import xyz.liweichao.auth.core.utils.ResponseUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 短信验证码处理器
 *
 * @author zhailiang
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsCodeSender smsCodeSender;

    @Autowired
    private ValidateCodeGenerator smsValidateCodeGenerator;

    @Autowired
    private RedisValidateCodeRepository redisValidateCodeRepository;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validateCode.getCode());
        HttpServletResponse response = request.getResponse();
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> result = Maps.newHashMap();
        result.put("message", "已发送成功，请注意查收！");
        ResponseUtils.json(response, result);
    }


    /**
     * 生成校验码
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        //校验
        if (redisValidateCodeRepository.hasKey(getUniqueKey(request), getValidateCodeType(request))) {
            throw new AuthException(String.format("请在 %d 秒后尝试获取验证码！", redisValidateCodeRepository.getExpire(getUniqueKey(request), getValidateCodeType(request))));
        }
        return smsValidateCodeGenerator.generate(request);
    }

    /**
     * SMS 获取 key 值为获取参数中的 mobile 值
     */
    @Override
    protected String getUniqueKey(ServletWebRequest request) {
        String result = "";
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        try {
            result = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
