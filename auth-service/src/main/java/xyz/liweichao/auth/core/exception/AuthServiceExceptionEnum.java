package xyz.liweichao.auth.core.exception;

/**
 * AuthServerExceptionEnum
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/30
 */

public enum AuthServiceExceptionEnum {
    /**
     * 异常列举出来
     */
    ;

    private final int value;

    private final String message;

    AuthServiceExceptionEnum(int value, String message) {
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
