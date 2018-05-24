package xyz.liweichao.auth.core.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
