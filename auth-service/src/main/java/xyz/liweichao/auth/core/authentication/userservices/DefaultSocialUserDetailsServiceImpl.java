package xyz.liweichao.auth.core.authentication.userservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.service.IColorsUserService;

/**
 * DefaultSocialUserDetailsServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/3/9
 */

@Component
public class DefaultSocialUserDetailsServiceImpl implements SocialUserDetailsService {


    @Autowired
    private IColorsUserService colorsUserService;

    @Override
    public ColorsUser loadUserByUserId(String userId) throws UsernameNotFoundException {
        return colorsUserService.loadUserByUniqueKey(userId);
    }

}
