package xyz.liweichao.auth.core.exception;

import com.github.hicolors.colors.framework.core.common.exception.RestfulException;
import org.springframework.http.HttpStatus;

/**
 * 验证异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/24
 */
public class AuthException extends RestfulException {

    public static final Long CODE = 10100001L;

    public AuthException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), CODE, message);
    }
}
