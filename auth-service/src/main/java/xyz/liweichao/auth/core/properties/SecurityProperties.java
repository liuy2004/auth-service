package xyz.liweichao.auth.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import xyz.liweichao.auth.core.properties.code.ValidateCodeProperties;
import xyz.liweichao.auth.core.properties.oauth.OAuth2Properties;
import xyz.liweichao.auth.core.properties.social.SocialProperties;

/**
 * 配置项
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Data
@ConfigurationProperties(prefix = "colors.security")
public class SecurityProperties {

    /**
     * 启用状态配置
     */
    private Boolean enable = false;

    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
    /**
     * 社交登录配置
     */
    private SocialProperties social = new SocialProperties();
    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();

}