package xyz.liweichao.auth;

import com.github.hicolors.colors.framework.core.common.utils.JsonUtils;
import com.github.hicolors.colors.framework.core.others.springmvc.aop.ExceptionHandlerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Auth Server Application
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/24
 */

@SpringBootApplication
//@EnableRedisson
public class AuthServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }


    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate() {
        LOGGER.info("使用 Jackson2JsonRedisSerialize 替换默认序列化。");
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(JsonUtils.getObjectMapper());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
