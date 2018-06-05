package xyz.liweichao.auth.core.code.repository;

import com.github.hicolors.colors.framework.core.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.code.base.ValidateCode;
import xyz.liweichao.auth.core.code.base.ValidateCodeType;
import xyz.liweichao.auth.core.code.exception.ValidateCodeException;
import xyz.liweichao.auth.core.code.exception.ValidateCodeExceptionEnum;

import java.util.concurrent.TimeUnit;

/**
 * 基于redis的验证码存取器，避免由于没有session导致无法存取验证码的问题
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    private final RedisTemplate<Object, Object> redisTemplate;

    public RedisValidateCodeRepository(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(JsonUtils.getObjectMapper());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.afterPropertiesSet();
    }

    @Override
    public void save(String key, ValidateCode code, ValidateCodeType type, long expireIn) {
        redisTemplate.opsForValue().set(buildKey(key, type), code, expireIn, TimeUnit.SECONDS);
    }


    @Override
    public ValidateCode get(String key, ValidateCodeType type) {
        Object value = redisTemplate.opsForValue().get(buildKey(key, type));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(String key, ValidateCodeType type) {
        redisTemplate.delete(buildKey(key, type));
    }

    @Override
    public boolean hasKey(String key, ValidateCodeType type) {
        return redisTemplate.hasKey(buildKey(key, type));
    }

    @Override
    public Long getExpire(String key, ValidateCodeType codeType) {
        return redisTemplate.getExpire(buildKey(key, codeType));
    }

    /**
     * @param key
     * @param type
     * @return
     */
    private String buildKey(String key, ValidateCodeType type) {
        if (StringUtils.isBlank(key)) {
            throw new ValidateCodeException(ValidateCodeExceptionEnum.KEY_IS_NULL, type.name());
        }
        return "validate:code:" + type.name() + ":" + key;
    }
}
