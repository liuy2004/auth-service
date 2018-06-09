package xyz.liweichao.auth.core.authentication.userservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.service.IColorsUserService;


/**
 * DefaultUserDetailsServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/3/9
 */

@Component
public class DefaultUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserDetailsServiceImpl.class);

    @Autowired
    private IColorsUserService colorsUserService;

    @Override
    public ColorsUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return colorsUserService.loadUserByUniqueKey(username);
    }
}