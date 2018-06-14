package xyz.liweichao.auth.core.authentication.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.properties.SecurityConstants;

/**
 * 密码登录配置
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component
public class FormAuthenticationSecurityConfig {

    @Autowired
    protected AuthenticationSuccessHandler colorsAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler colorsAuthenticationFailureHandler;

    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHORIZED_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
                .successHandler(colorsAuthenticationSuccessHandler)
                .failureHandler(colorsAuthenticationFailureHandler);

        //不创建 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //废弃 session
        http.sessionManagement().disable();

    }

}
