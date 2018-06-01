package xyz.liweichao.auth.core.custom;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import com.github.hicolors.colors.framework.common.utils.ErrorCodeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import xyz.liweichao.auth.core.exception.AuthServiceException;
import xyz.liweichao.auth.core.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ColorsExceptionEntryPoint
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/29
 */

public class ColorsExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        AuthServiceException restfulException = new AuthServiceException(
                HttpStatus.UNAUTHORIZED,
                ErrorCodeUtils.generator(2,2,1),
                authException.getMessage(),
                authException);
        ResponseUtils.json(request, response, restfulException);
    }
}