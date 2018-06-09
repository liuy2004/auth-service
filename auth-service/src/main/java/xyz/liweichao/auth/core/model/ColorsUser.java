package xyz.liweichao.auth.core.model;

import com.github.hicolors.colors.framework.common.utils.DateUtils;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * ColorsUser
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */
@Data
@NoArgsConstructor
public class ColorsUser implements UserDetails, SocialUserDetails {

    /**
     * 系统中的 id
     */
    private Long id;

    /**
     * comment: 	昵称
     */
    private String nickName;

    /**
     * comment: 	用户名
     */
    private String username;


    /**
     * comment: 	密码
     */
    private String password;

    /**
     * comment: 	状态[0:未启用;1:启用]
     */
    private Boolean enabled;

    /**
     * comment: 	锁定状态[0:未锁定;1:锁定]
     */
    private Boolean lockStatus;


    /**
     * comment: 	过期时间
     */
    private Date expiredDate;

    /**
     * comment: 	凭证过期时间
     */
    private Date credentialsExpiredDate;

    /**
     * comment: 	邮箱
     */
    private String email;

    /**
     * comment: 	手机号
     */
    private String mobile;

    /**
     * comment: 	姓名
     */
    private String name;

    /**
     * comment: 	出生日期
     */
    private Date birthday;

    /**
     * comment: 	描述
     */
    private String description;

    /**
     * comment: 	主页
     */
    private String website;

    /**
     * comment: 	头像
     */
    private String favicon;

    /**
     * 角色
     */
    private Set<String> roles;

    @Override
    public String getUserId() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isNotEmpty(roles)) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(Arrays.toString(roles.stream().map(e -> e = "ROLE_" + e).toArray()));
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return DateUtils.compare(DateUtils.now(), expiredDate) < 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !lockStatus;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return DateUtils.compare(DateUtils.now(), credentialsExpiredDate) < 0;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public SimpleColorsUser buildSimpleColorsUser() {
        return SimpleColorsUser.builder()
                .id(this.id)
                .nickName(this.nickName)
                .email(email)
                .mobile(mobile)
                .name(name)
                .birthday(birthday)
                .description(description)
                .website(website)
                .favicon(favicon)
                .build();
    }


    @Builder
    @Data
    private static class SimpleColorsUser {

        private Long id;

        private String nickName;

        private String email;

        private String mobile;

        private String name;

        private Date birthday;

        private String description;

        private String website;

        private String favicon;
    }
}
