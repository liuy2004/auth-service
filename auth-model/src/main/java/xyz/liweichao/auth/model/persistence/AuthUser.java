package xyz.liweichao.auth.model.persistence;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.github.hicolors.colors.framework.core.common.abs.AbstractBean;

import java.util.Date;

/**
 * comment: 用户认证信息
 *
 * @author liweichao
 * @date 2018-5-12 10:53:45
 */
@JsonFilter("auth-user")
@javax.persistence.Entity
@javax.persistence.Table(name = "auth_user")
public class AuthUser extends AbstractBean {
    /**
     * comment: 	主键
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @javax.persistence.Column(name = "id")
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;

    /**
     * comment: 	昵称
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	64
     */
    @javax.persistence.Column(name = "nick_name")
    private String nickName;

    /**
     * comment: 	用户名
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	32
     */
    @javax.persistence.Column(name = "username")
    private String username;

    /**
     * comment: 	密码
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	64
     */
    @javax.persistence.Column(name = "password")
    private String password;

    /**
     * comment: 	状态
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	1
     */
    @javax.persistence.Column(name = "enabled")
    private Boolean enabled;

    /**
     * comment: 	锁定状态
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	1
     */
    @javax.persistence.Column(name = "lock_status")
    private Boolean lockStatus;

    /**
     * comment: 	过期时间
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	19
     */
    @javax.persistence.Column(name = "expired_date")
    private Date expiredDate;

    /**
     * comment: 	凭证过期时间
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	19
     */
    @javax.persistence.Column(name = "credentials_expired_date")
    private Date credentialsExpiredDate;


    public Long getId() {
        return id;
    }

    public AuthUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public AuthUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public AuthUser setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getLockStatus() {
        return lockStatus;
    }

    public AuthUser setLockStatus(Boolean lockStatus) {
        this.lockStatus = lockStatus;
        return this;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public AuthUser setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
        return this;
    }

    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public AuthUser setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
        return this;
    }
}