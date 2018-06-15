package xyz.liweichao.auth.core.authorize;

import com.github.hicolors.colors.framework.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.exception.AuthServiceException;

import java.util.List;

/**
 * 默认的授权配置管理器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component
public class ColorsAuthorizeConfigManager implements AuthorizeConfigManager {

    @Autowired
    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        boolean existAnyRequestConfig = false;

        String existAnyRequestConfigName = null;

        for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {

            boolean isAnyRequestConfig = authorizeConfigProvider.config(config);

            if (existAnyRequestConfig && isAnyRequestConfig) {
                throw new AuthServiceException(
                        StringUtils.format("重复的 anyRequest 配置: [{}] -> [{}]", existAnyRequestConfigName, authorizeConfigProvider.getClass().getSimpleName())
                );

            } else if (isAnyRequestConfig) {
                existAnyRequestConfig = true;
                existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
            }
        }

        if(!existAnyRequestConfig){
            config.anyRequest().authenticated();
        }
    }

}