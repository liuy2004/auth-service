package xyz.liweichao.auth.core.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import xyz.liweichao.auth.core.properties.SecurityProperties;

/**
 * token store 配置类
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/17
 */
@Configuration
public class TokenStoreConfiguration {

    /**
     * 使用redis存储token的配置，colors.security.oauth2.tokenStore配置为redis时生效
     */
    @Configuration
    @ConditionalOnProperty(prefix = "colors.security.oauth2", name = "tokenStore", havingValue = "redis", matchIfMissing = true)
    public static class RedisConfig {

        @Autowired
        private SecurityProperties securityProperties;

        @Autowired
        private RedisConnectionFactory redisConnectionFactory;

        /**
         * @return
         */
        @Bean
        public TokenStore tokenStore() {
            RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
            redisTokenStore.setPrefix(securityProperties.getOauth2().getPrefix());
            redisTokenStore.setSerializationStrategy(new JdkSerializationStrategy());
            return redisTokenStore;
        }

    }

    /**
     * 使用jwt时的配置，默认生效
     */
    @Configuration
    @ConditionalOnProperty(prefix = "colors.security.oauth2", name = "tokenStore", havingValue = "jwt")
    public static class JwtConfig {

        @Autowired
        private SecurityProperties securityProperties;

        /**
         * @return
         */
        @Bean
        public TokenStore tokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setSigningKey(securityProperties.getOauth2().getDigitalSignature());
            return converter;
        }

        /**
         * @return
         */
        @Bean
        @ConditionalOnBean(TokenEnhancer.class)
        public TokenEnhancer jwtTokenEnhancer() {
            return new JwtTokenEnhancer();
        }

    }


}
