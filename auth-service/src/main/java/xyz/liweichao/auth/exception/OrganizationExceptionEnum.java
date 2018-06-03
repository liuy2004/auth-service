package xyz.liweichao.auth.exception;


/**
 * 验证码 异常枚举
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public enum OrganizationExceptionEnum {

    /**
     * 异常列举出来
     */
    PARENT_ID_NOT_FOUND(1, "父级节点[{}]未找到。"),;

    private final int value;

    private final String message;


    OrganizationExceptionEnum(int value, String message) {
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