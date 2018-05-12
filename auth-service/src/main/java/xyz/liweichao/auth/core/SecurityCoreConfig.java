package xyz.liweichao.auth.core;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import xyz.liweichao.auth.core.properties.SecurityProperties;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 安全模块 配置类
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

    @Resource
    public DataSource dataSource;

    /**
     * 默认密码处理器
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 记住我功能的token存取器配置
     *
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //初次需要建表
        tokenRepository.setCreateTableOnStartup(false);
        return tokenRepository;
    }

//    /**
//     * 默认认证器
//     *
//     * @return
//     */
//    @Bean
//    @ConditionalOnMissingBean(UserDetailsService.class)
//    public UserDetailsService userDetailsService() {
//        return new DefaultUserDetailsService();
//    }
//
//    /**
//     * 默认认证器
//     *
//     * @return
//     */
//    @Bean
//    @ConditionalOnMissingBean(SocialUserDetailsService.class)
//    public SocialUserDetailsService socialUserDetailsService() {
//        return new DefaultSocialUserDetailsService();
//    }

}
