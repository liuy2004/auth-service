package xyz.liweichao.auth.core.social;

import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.core.social.support.SocialUserInfo;

/**
 * 社交账户信息Service
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/14
 */
@Service
public class SocialUserService {

    /**
     * 根据Connection信息构建SocialUserInfo
     *
     * @param connection
     * @return
     */
    public SocialUserInfo build(Connection<?> connection) {
        SocialUserInfo userInfo = new SocialUserInfo();
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadimg(connection.getImageUrl());
        return userInfo;
    }

}
