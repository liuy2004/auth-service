package xyz.liweichao.auth.core.code.sms;

/**
 * 短信验证码发送器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public interface SmsCodeSender {

    /**
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);

}
