package xyz.liweichao.auth.core.custom;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CustomAccessDeniedHandler
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/29
 */

@Component("colorsAccessDeniedHandler")
public class ColorsAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        RestfulException restfulException = new RestfulException(
                HttpStatus.UNAUTHORIZED, 1001001L,
                accessDeniedException.getMessage(),
                accessDeniedException);
        ResponseUtils.json(request, response, restfulException);
    }
}