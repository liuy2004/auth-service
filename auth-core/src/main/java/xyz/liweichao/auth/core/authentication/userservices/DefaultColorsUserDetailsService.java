package xyz.liweichao.auth.core.authentication.userservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.service.IColorsUserService;

/**
 * 默认的 UserDetailsService 实现
 * 不做任何处理，只在控制台打印一句日志，然后抛出异常，提醒业务系统自己配置 UserDetailsService。
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class DefaultColorsUserDetailsService implements IColorsUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultColorsUserDetailsService.class);

    @Override
    public ColorsUser loadUserByUniqueKey(String uniqueKey) {
        LOGGER.warn("请配置 IColorsUserService 接口的实现.");
        throw new UsernameNotFoundException(uniqueKey);
    }
}
