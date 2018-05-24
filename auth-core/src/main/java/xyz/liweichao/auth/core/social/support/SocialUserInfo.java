package xyz.liweichao.auth.core.social.support;

/**
 * 社交用户信息
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;

    public String getProviderId() {
        return providerId;
    }

    public SocialUserInfo setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public SocialUserInfo setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public SocialUserInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getHeadimg() {
        return headimg;
    }

    public SocialUserInfo setHeadimg(String headimg) {
        this.headimg = headimg;
        return this;
    }
}
