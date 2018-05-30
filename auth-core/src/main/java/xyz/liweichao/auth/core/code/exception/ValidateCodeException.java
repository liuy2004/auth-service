package xyz.liweichao.auth.core.code.exception;


import com.github.hicolors.colors.framework.common.utils.ErrorCodeUtils;
import com.github.hicolors.colors.framework.common.utils.StringUtils;
import org.springframework.http.HttpStatus;
import xyz.liweichao.auth.core.exception.AuthServiceException;

/**
 * 验证码 异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class ValidateCodeException extends AuthServiceException {

    private static final int MODULE_ID = 1;

    public ValidateCodeException(String message) {
        this(0, message, null);
    }

    public ValidateCodeException(ValidateCodeExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), null);
    }

    public ValidateCodeException(Object data, ValidateCodeExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), data);
    }

    private ValidateCodeException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST,
                ErrorCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }
}