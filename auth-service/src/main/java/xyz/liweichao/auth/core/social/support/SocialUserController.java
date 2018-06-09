package xyz.liweichao.auth.core.social.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import xyz.liweichao.auth.core.properties.SecurityConstants;
import xyz.liweichao.auth.core.social.SocialUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册用户
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@RestController
public class SocialUserController {

    @Autowired(required = false)
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private RedisProviderSignInUtils redisProviderSignInUtils;

    @Autowired
    private SocialUserService socialUserService;

    /**
     * 需要注册时跳到这里，返回401和用户信息给前端
     *
     * @param request
     * @return
     */
    @GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        redisProviderSignInUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
        return socialUserService.build(connection);
    }

}
