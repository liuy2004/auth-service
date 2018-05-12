package xyz.liweichao.auth.core.handler;

import com.github.hicolors.colors.framework.core.common.utils.JsonUtils;
import com.github.hicolors.colors.framework.core.others.springmvc.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import xyz.liweichao.auth.core.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * APP环境下认证失败处理器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component
public class ColorsAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws ServletRequestBindingException {
        logger.warn("[{}] 登录失败", ServletRequestUtils.getStringParameter(request, "mobile", ServletRequestUtils.getStringParameter(request, "username")));
        if (logger.isDebugEnabled()) {
            logger.debug("出错信息日志为 [{}] ", JsonUtils.serializeExcludes(request.getParameterMap()));
        }
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        ErrorResponse er = new ErrorResponse(request);
        er.setCode(40101F);
        er.setMessage(exception.getMessage());
        ResponseUtils.json(response, er);

    }

}
