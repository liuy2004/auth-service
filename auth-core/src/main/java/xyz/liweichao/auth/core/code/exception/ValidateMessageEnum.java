package xyz.liweichao.auth.core.code.exception;


/**
 * 异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public enum ValidateMessageEnum {

    A(0, "验证码处理器[{0}]不存在。"),
    B(1, "验证码生成器{0}不存在。"),
    C(2, "Request 请求中获取验证码参数失败。"),
    D(3, "{0} :验证码的值不能为空。"),
    E(4, "{0} :验证码不存在。"),
    F(5, "{0} :验证码已过期。"),
    G(6, "{0} :验证码不匹配。"),
    H(7, "Type[{0}]：生成验证码 key 时出错，key 为 null。"),
    I(8, "请在 {0} 秒后尝试获取验证码！");

    private final int value;

    private final String message;


    ValidateMessageEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public static ValidateMessageEnum valueOf(int value) {
        for (ValidateMessageEnum status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }
}