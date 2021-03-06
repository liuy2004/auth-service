package xyz.liweichao.auth.core.code.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.code.base.ValidateCode;
import xyz.liweichao.auth.core.code.base.ValidateCodeType;
import xyz.liweichao.auth.core.code.exception.ValidateCodeException;

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
            throw new ValidateCodeException(ValidateCodeException.EnumMsg.KEY_IS_NULL, type.name());
        }
        return "auth:validate:code:" + type.name() + ":" + key;
    }
}