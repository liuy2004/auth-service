package xyz.liweichao.auth.core.code.sms;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.context.request.ServletWebRequest;
import xyz.liweichao.auth.core.code.base.ValidateCode;
import xyz.liweichao.auth.core.code.base.ValidateCodeGenerator;
import xyz.liweichao.auth.core.properties.SecurityProperties;

/**
 * 短信验证码生成器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class SmsCodeGenerator implements ValidateCodeGenerator {

    private SecurityProperties securityProperties;

    public SmsCodeGenerator(SecurityProperties securityProperties){
        this.securityProperties = securityProperties;
    }

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }


}
