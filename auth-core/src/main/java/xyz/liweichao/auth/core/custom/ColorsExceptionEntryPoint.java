package xyz.liweichao.auth.core.custom;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
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
        //org.springframework.security.authentication.InsufficientAuthenticationException
        //org.springframework.security.authentication.InsufficientAuthenticationException
        // : Full authentication is required to access this resource
        // : Invalid access token: 174cd16e-6e79-4382-a85d-fd7a29c312e9
        RestfulException restfulException = new RestfulException(
                HttpStatus.UNAUTHORIZED, 1L,
                authException.getMessage(),
                authException);
        ResponseUtils.json(request, response, restfulException);
    }
}