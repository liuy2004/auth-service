package xyz.liweichao.auth.core.code;


import com.github.hicolors.colors.framework.common.exception.RestfulException;
import org.springframework.http.HttpStatus;

/**
 * 异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class ValidateCodeException extends RestfulException {

    private static final long code = 1001002;

    public ValidateCodeException(String msg) {
        super(HttpStatus.BAD_REQUEST, code, msg, null);
    }

}
