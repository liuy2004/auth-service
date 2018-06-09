package xyz.liweichao.auth.core.code.exception;


/**
 * 验证码 异常枚举
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public enum ValidateCodeExceptionEnum {

    /**
     * 异常列举出来
     */
    PROCESSOR_NOT_FOUND(1, "验证码处理器[{}]不存在。"),
    GENERATOR_NOT_FOUND(2, "验证码生成器[{}]不存在。"),
    REQUEST_PARAM_NOT_FOUND(3, "Request 请求中获取验证码参数失败。"),
    VALIDATE_CODE_IS_NULL(4, "[{}]验证码的值不能为空。"),
    VALIDATE_CODE_NOT_FOUND(5, "[{}][{}]验证码已失效。"),
    VALIDATE_CODE_OVERDUE(6, "[{}][{}]验证码已过期。"),
    VALIDATE_CODE_INCORRECTNESS(7, "[{}][{}]验证码不匹配。"),
    KEY_IS_NULL(8, "Type[{}]生成验证码 key 时出错，key 为 null。"),
    OPERATION_VALIDATE_CODE_TOO_MUCH(9, "请在[{}]秒后尝试获取验证码！");

    private final int value;

    private final String message;


    ValidateCodeExceptionEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}