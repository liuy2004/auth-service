package xyz.liweichao.auth.core.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * 默认的短信验证码发送器
 *
 * @author zhailiang
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

    @Override
    public void send(String mobile, String code) {
        LOGGER.error("请配置真实的短信验证码发送器(SmsCodeSender)");
        LOGGER.info(MessageFormat.format("向手机[{0}}发送短信验证码:[{1}]", mobile, code));
    }

}
