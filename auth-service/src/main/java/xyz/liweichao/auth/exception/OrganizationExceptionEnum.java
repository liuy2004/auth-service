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
    PARENT_ID_NOT_FOUND(1, "当前组织机构父级节点[{}]未找到。"),
    HAS_CHILDREN(2, "当前组织机构节点还有子节点。"),
    HAS_USER(3, "当前组织机构节点还有人员。"),
    CODE_EXISTING(4,"当前组织机构代码[{}]已被占用！"),
    ;

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