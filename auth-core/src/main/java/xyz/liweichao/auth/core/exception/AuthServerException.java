package xyz.liweichao.auth.core.exception;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import com.github.hicolors.colors.framework.common.utils.ErrorCodeUtils;
import com.github.hicolors.colors.framework.common.utils.StringUtils;
import org.springframework.http.HttpStatus;

/**
 * AuthServerException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/30
 */
public class AuthServerException extends RestfulException {


    protected static final int APP_ID = 2;

    private static final int MODULE_ID = 0;


    public AuthServerException(String message) {
        this(0, message, null);
    }

    public AuthServerException(AuthServerExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), null);
    }

    public AuthServerException(Object data, AuthServerExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), data);
    }

    private AuthServerException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST,
                ErrorCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }

    public AuthServerException(HttpStatus statusCode, Long code, String message, Object data) {
        super(statusCode, code, message, data);
    }

}