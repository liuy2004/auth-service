package xyz.liweichao.auth.exception;

import com.github.hicolors.colors.framework.common.utils.StringUtils;
import com.github.hicolors.colors.framework.exception.utils.ExceptionCodeUtils;
import org.springframework.http.HttpStatus;
import xyz.liweichao.auth.core.exception.AuthServiceException;

/**
 * RoleException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/4
 */
public class UserDetailException extends AuthServiceException {

    private static final int MODULE_ID = 6;

    public UserDetailException(String message) {
        this(0, message, null);
    }

    public UserDetailException(UserDetailExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), null);
    }

    public UserDetailException(Object data, UserDetailExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), data);
    }

    public UserDetailException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST.value(),
                ExceptionCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }
}
