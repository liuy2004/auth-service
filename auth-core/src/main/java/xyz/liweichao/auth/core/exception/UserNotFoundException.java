package xyz.liweichao.auth.core.exception;

import com.github.hicolors.colors.framework.common.utils.ErrorCodeUtils;
import org.springframework.http.HttpStatus;

/**
 * UserNotFoundException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */

public class UserNotFoundException extends AuthServiceException {

    private static final int MODULE_ID = 3;

    public UserNotFoundException(String message) {
        this(0, message, null);
    }

    private UserNotFoundException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST,
                ErrorCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }
}