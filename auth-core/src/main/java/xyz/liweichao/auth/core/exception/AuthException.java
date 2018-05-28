package xyz.liweichao.auth.core.exception;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import org.springframework.http.HttpStatus;

/**
 * 验证异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/24
 */
public class AuthException extends RestfulException {

    private static final Long CODE = 1001001L;


    public AuthException(String message) {
        super(HttpStatus.BAD_REQUEST, CODE, message, null);
    }

    public AuthException(String message, Object data) {
        super(HttpStatus.BAD_REQUEST, CODE, message, data);
    }

    public AuthException(Long code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message, null);
    }

    public AuthException(Long code, String message, Object data) {
        super(HttpStatus.BAD_REQUEST, code, message, data);
    }

    public AuthException(HttpStatus status, Long code, String message, Object data) {
        super(status, code, message, data);
    }

}
