package xyz.liweichao.auth.core.handler;

import com.github.hicolors.colors.framework.core.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import xyz.liweichao.auth.core.exception.AuthServiceException;
import xyz.liweichao.auth.core.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * APP环境下认证失败处理器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component
public class ColorsAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(ColorsAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws ServletRequestBindingException {
        LOGGER.error("[{}] 登录失败",
                ServletRequestUtils.getStringParameter(request, "mobile",
                        ServletRequestUtils.getStringParameter(request, "username")));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("出错信息日志为 [{}] ", JsonUtils.serializeExcludes(request.getParameterMap()));
        }

        ResponseUtils.json(request, response, new AuthServiceException(exception.getMessage()));
    }

}