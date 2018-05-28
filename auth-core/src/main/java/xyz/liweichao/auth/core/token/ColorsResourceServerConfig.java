package xyz.liweichao.auth.core.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;
import xyz.liweichao.auth.core.authentication.code.ValidateCodeSecurityConfig;
import xyz.liweichao.auth.core.authentication.form.FormAuthenticationSecurityConfig;
import xyz.liweichao.auth.core.authentication.openid.OpenIdAuthenticationSecurityConfig;
import xyz.liweichao.auth.core.authentication.sms.SmsCodeAuthenticationSecurityConfig;
import xyz.liweichao.auth.core.authorize.AuthorizeConfigManager;

/**
 * 资源服务器配置
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Configuration
@EnableResourceServer
public class ColorsResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler colorsAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler colorsAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer colorsSocialSecurityConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private FormAuthenticationSecurityConfig formAuthenticationSecurityConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        formAuthenticationSecurityConfig.configure(http);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(colorsSocialSecurityConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                .csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }

}