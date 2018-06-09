package xyz.liweichao.auth.exception;


/**
 * 验证码 异常枚举
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public enum UserDetailExceptionEnum {

    /**
     * 异常列举出来
     */
    UNIQUE_CONFLICT(1, "当前唯一约束[{}]冲突！"),
    PASSWORD_INCORRECT(1, "旧密码不正确，不能修改！"),
    ;

    private final int value;

    private final String message;


    UserDetailExceptionEnum(int value, String message) {
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