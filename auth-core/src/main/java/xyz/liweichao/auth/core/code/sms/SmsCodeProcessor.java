package xyz.liweichao.auth.core.code.sms;

import com.github.hicolors.colors.framework.common.utils.DateUtils;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import xyz.liweichao.auth.core.code.exception.ValidateCodeException;
import xyz.liweichao.auth.core.code.base.AbstractValidateCodeProcessor;
import xyz.liweichao.auth.core.code.base.ValidateCode;
import xyz.liweichao.auth.core.code.base.ValidateCodeGenerator;
import xyz.liweichao.auth.core.code.exception.ValidateMessageEnum;
import xyz.liweichao.auth.core.code.repository.RedisValidateCodeRepository;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsCodeProcessor.class);

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
    protected void send(ServletWebRequest request, ValidateCode validateCode){
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = null;
        try {
            mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException(ValidateMessageEnum.valueOf(2));
        }
        smsCodeSender.send(mobile, validateCode.getCode());
        HttpServletResponse response = request.getResponse();
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> result = Maps.newHashMap();
        result.put("message", "已发送成功，请注意查收！");
        result.put("timestamp",DateUtils.now());
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
        if (redisValidateCodeRepository.hasKey(getUniqueKey(request), getValidateCodeType())) {
            long s = redisValidateCodeRepository.getExpire(getUniqueKey(request), getValidateCodeType());
            throw new ValidateCodeException(ValidateMessageEnum.valueOf(8),s);
        }
        return smsValidateCodeGenerator.generate(request);
    }

    /**
     * SMS 获取 key 值为获取参数中的 mobile 值
     */
    @Override
    protected String getUniqueKey(ServletWebRequest request) {
        String result = null;
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        try {
            result = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException(ValidateMessageEnum.valueOf(2));
        }
        return result;
    }
}
