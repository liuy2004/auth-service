package xyz.liweichao.auth.core.social.support.exception;


import com.github.hicolors.colors.framework.exception.utils.ExceptionCodeUtils;
import org.springframework.http.HttpStatus;
import xyz.liweichao.auth.core.exception.AuthServiceException;

/**
 * SocialUserNotFoundException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/30
 */
public class SocialUserNotFoundException extends AuthServiceException {

    private static final int MODULE_ID = 2;

    public SocialUserNotFoundException(String message) {
        this(0, message, null);
    }

    private SocialUserNotFoundException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST.value(),
                ExceptionCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }

}
