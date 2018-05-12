package xyz.liweichao.auth.core.authentication.userservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * 默认的SocialUserDetailsService实现
 * 不做任何处理，只在控制台打印一句日志，然后抛出异常，提醒业务系统自己配置SocialUserDetailsService。
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class DefaultSocialUserDetailsService implements SocialUserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSocialUserDetailsService.class);

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        LOGGER.warn("请配置 SocialUserDetailsService 接口的实现.");
        throw new UsernameNotFoundException(userId);
    }

}
