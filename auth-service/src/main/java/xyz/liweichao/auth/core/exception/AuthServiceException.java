package xyz.liweichao.auth.core.exception;

import com.github.hicolors.colors.framework.common.utils.StringUtils;
import com.github.hicolors.colors.framework.exception.RestfulException;
import com.github.hicolors.colors.framework.exception.utils.ExceptionCodeUtils;
import org.springframework.http.HttpStatus;

/**
 * AuthServerException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/30
 */
public class AuthServiceException extends RestfulException {


    protected static final int APP_ID = 2;

    private static final int MODULE_ID = 0;


    public AuthServiceException(String message) {
        this(0, message, null);
    }

    public AuthServiceException(AuthServiceExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), null);
    }

    public AuthServiceException(Object data, AuthServiceExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), data);
    }

    public AuthServiceException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST.value(),
                ExceptionCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }

    public AuthServiceException(int statusCode, long code, String message, Object data) {
        super(statusCode, code, message, data);
    }

}