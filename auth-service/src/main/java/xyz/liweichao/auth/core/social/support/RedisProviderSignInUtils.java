package xyz.liweichao.auth.core.social.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import xyz.liweichao.auth.core.social.support.exception.SocialUserNotFoundException;

import java.util.concurrent.TimeUnit;

/**
 * app环境下替换providerSignInUtils，避免由于没有session导致读不到社交用户信息的问题
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/9
 */
@Component
public class RedisProviderSignInUtils {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    /**
     * 缓存社交网站用户信息到redis
     *
     * @param request
     * @param connectionData
     */
    public void saveConnectionData(WebRequest request, ConnectionData connectionData) {
        redisTemplate.opsForValue().set(getKey(request), connectionData, 10, TimeUnit.MINUTES);
    }

    /**
     * 将缓存的社交网站用户信息与系统注册用户信息绑定
     *
     * @param request
     * @param userId
     */
    public void doPostSignUp(WebRequest request, String userId) {

        String key = getKey(request);
        if (!redisTemplate.hasKey(key)) {
            throw new SocialUserNotFoundException("无法找到缓存的用户社交账号信息！");
        }
        ConnectionData connectionData = (ConnectionData) redisTemplate.opsForValue().get(key);
        Connection<?> connection = connectionFactoryLocator.getConnectionFactory(
                connectionData.getProviderId())
                .createConnection(connectionData);

        usersConnectionRepository.createConnectionRepository(userId).addConnection(connection);

        redisTemplate.delete(key);
    }

    /**
     * 获取redis key
     *
     * @param request
     * @return
     */
    private String getKey(WebRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("colors:security:social.connect:").append("-").append(request.getHeader("deviceId"));
        return sb.toString();
    }

}
