package xyz.liweichao.auth.exception;


/**
 * 验证码 异常枚举
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public enum RoleExceptionEnum {

    /**
     * 异常列举出来
     */
    GOURP_NOT_FOUNT(1, "当前角色组信息[{}]未找到。"),
    ;

    private final int value;

    private final String message;


    RoleExceptionEnum(int value, String message) {
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