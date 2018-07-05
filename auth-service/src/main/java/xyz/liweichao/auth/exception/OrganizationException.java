package xyz.liweichao.auth.exception;

import com.github.hicolors.colors.framework.common.utils.StringUtils;
import com.github.hicolors.colors.framework.exception.utils.ExceptionCodeUtils;
import org.springframework.http.HttpStatus;
import xyz.liweichao.auth.core.exception.AuthServiceException;

public class OrganizationException extends AuthServiceException {

    private static final int MODULE_ID = 4;

    public OrganizationException(String message) {
        this(0, message, null);
    }

    public OrganizationException(OrganizationExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), null);
    }

    public OrganizationException(Object data, OrganizationExceptionEnum exceptionEnum, Object... objects) {
        this(exceptionEnum.getValue(), StringUtils.format(exceptionEnum.getMessage(), objects), data);
    }

    public OrganizationException(int specific, String message, Object data) {
        super(HttpStatus.BAD_REQUEST.value(),
                ExceptionCodeUtils.generator(APP_ID, MODULE_ID, specific),
                message, data);
    }
}
