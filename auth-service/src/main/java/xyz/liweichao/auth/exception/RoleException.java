package xyz.liweichao.auth.exception;

import com.github.hicolors.colors.framework.common.utils.ErrorCodeUtils;
import com.github.hicolors.colors.framework.common.utils.StringUtils;
import org.springframework.http.HttpStatus;
import xyz.liweichao.auth.core.exception.AuthServiceException;

/**
 * RoleException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/4
 */
public class RoleException extends AuthServiceException {

    private static final int MODULE_ID = 5;

    public RoleException(String message) {
        this(0, message, null);
    }

    public RoleException(RoleExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), null);
    }

    public RoleException(Object data, RoleExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), data);
    }

    public RoleException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST,
                ErrorCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }
}
