package xyz.liweichao.auth.core.social.support.postprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.handler.ColorsAuthenticationSuccessHandler;

/**
 * 默认后置处理器
 *
 * @author 李伟超
 * @date 2018/03/14
 */
@Component
public class DefaultSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {

    @Autowired
    private ColorsAuthenticationSuccessHandler colorsAuthenticationSuccessHandler;

    @Override
    public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
        socialAuthenticationFilter.setAuthenticationSuccessHandler(colorsAuthenticationSuccessHandler);
    }
}
