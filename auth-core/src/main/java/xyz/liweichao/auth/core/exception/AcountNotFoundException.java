package xyz.liweichao.auth.core.exception;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import org.springframework.http.HttpStatus;

/**
 * AcountNotFoundException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */

public class AcountNotFoundException extends RestfulException {

    private static final long CODE = 2002001L;

    public AcountNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST, CODE, message, (Object) null);
    }

    public AcountNotFoundException(String message, Object data) {
        super(HttpStatus.BAD_REQUEST, CODE, message, data);
    }

    public AcountNotFoundException(Long code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message, (Object) null);
    }

    public AcountNotFoundException(Long code, String message, Object data) {
        super(HttpStatus.BAD_REQUEST, code, message, data);
    }

    public AcountNotFoundException(HttpStatus status, Long code, String message, Object data) {
        super(status, code, message, data);
    }
}
