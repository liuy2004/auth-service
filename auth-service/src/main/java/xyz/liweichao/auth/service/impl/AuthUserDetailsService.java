package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.common.utils.DateUtils;
import com.github.hicolors.colors.framework.core.common.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.service.IColorsUserService;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;
import xyz.liweichao.auth.service.IUserService;

import java.util.Calendar;

@Service
public class AuthUserDetailsService implements UserDetailsService, SocialUserDetailsService,IColorsUserService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserDetailService userDetailService;

    @Override
    public User loadUserByUsername(String uniqueIdentifier) throws UsernameNotFoundException {
        return loadUser(uniqueIdentifier);
    }

    @Override
    public SocialUser loadUserByUserId(String uniqueIdentifier) throws UsernameNotFoundException {
        return (SocialUser) loadUser(uniqueIdentifier);
    }

    @Override
    public ColorsUser loadUserByUniqueKey(String uniqueKey) {
        ColorsUser colorsUser = new ColorsUser();
        xyz.liweichao.auth.model.persistence.User user = userService.loadUserAuthInfo(uniqueKey);
        UserDetail userDetail = userDetailService.queryOne(user.getId());
        BeanUtils.copyProperties(user,colorsUser);
        BeanUtils.copyProperties(userDetail,colorsUser);
        return colorsUser;
    }

    private User loadUser(String uniqueIdentifier) {
        xyz.liweichao.auth.model.persistence.User user = userService.loadUserAuthInfo(uniqueIdentifier);
        return new User(user.getUsername(), user.getPassword(),
                user.getEnabled(), (org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(user.getExpiredDate(), DateUtils.now(), Calendar.DATE)) > 0,
                (org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(user.getCredentialsExpiredDate(), DateUtils.now(), Calendar.DATE) > 0),
                !user.getLockStatus(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_COLORS"));
    }
}