package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.service.IUserService;

import java.util.Calendar;

@Service
public class AuthUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public User loadUserByUsername(String uniqueIdentifier) throws UsernameNotFoundException {
        return queryUser(uniqueIdentifier);
    }

    @Override
    public SocialUser loadUserByUserId(String uniqueIdentifier) throws UsernameNotFoundException {
        return (SocialUser) queryUser(uniqueIdentifier);
    }

    private User queryUser(String uniqueIdentifier) {
        xyz.liweichao.auth.model.persistence.User user = userService.queryByUniqueKey(uniqueIdentifier);
        return new User(user.getUsername(), user.getPassword(),
                user.getEnabled(), (org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(user.getExpiredDate(), DateUtils.now(), Calendar.DATE)) > 0,
                (org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(user.getCredentialsExpiredDate(), DateUtils.now(), Calendar.DATE) > 0),
                !user.getLockStatus(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_COLORS"));
    }
}