//package xyz.liweichao.auth.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.social.security.SocialUser;
//import org.springframework.social.security.SocialUserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ColorsUserDetailsService implements UserDetailsService, SocialUserDetailsService {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public User loadUserByUsername(String username) throws UsernameNotFoundException {
//        return buildUser(username);
//    }
//
//    @Override
//    public SocialUser loadUserByUserId(String s) throws UsernameNotFoundException {
//        return (SocialUser) buildUser(s);
//    }
//
//    private User buildUser(String userId) {
//        // 根据用户名查找用户信息
//        //根据查找到的用户信息判断用户是否被冻结
//        String password = passwordEncoder.encode("123456");
//        return new User(userId, password,
//                true, true, true, true,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//    }
//}