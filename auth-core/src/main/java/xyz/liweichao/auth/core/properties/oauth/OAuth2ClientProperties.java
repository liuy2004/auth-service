package xyz.liweichao.auth.core.properties.oauth;

import lombok.Data;

/**
 * 认证服务器注册的第三方应用配置项
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Data
public class OAuth2ClientProperties {

    /**
     * 第三方应用appId
     */
    private String clientId;
    /**
     * 第三方应用appSecret
     */
    private String clientSecret;
    /**
     * 针对此应用发出的token的有效时间
     */
    private Integer accessTokenValidateSeconds = 7200;

    private Integer refreshTokenValiditySeconds = 30 * 24 * 60 * 60;

}
