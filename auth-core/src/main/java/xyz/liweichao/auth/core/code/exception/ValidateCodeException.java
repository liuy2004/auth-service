package xyz.liweichao.auth.core.code.exception;


import com.github.hicolors.colors.framework.common.exception.RestfulException;
import com.github.hicolors.colors.framework.common.utils.ErrorCodeUtils;
import com.github.hicolors.colors.framework.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * 异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class ValidateCodeException extends RestfulException {


    public static final int APP_ID = 2;

    public static final int MODULE_ID = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateCodeException.class);

    public ValidateCodeException(ValidateMessageEnum validateMessageEnum, Object... objects) {
        this(validateMessageEnum.getValue(),StringUtils.format(validateMessageEnum.getMessage(),objects));
    }

    private ValidateCodeException(int specific, String message) {
        super(HttpStatus.BAD_REQUEST,
                ErrorCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, null);
    }

    public ValidateCodeException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST,
                ErrorCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }
}