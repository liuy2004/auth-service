package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.core.common.abs.AbstractBean;

import javax.persistence.*;
import java.util.Date;

/**
 * comment: 用户认证信息
 *
 * @author liweichao
 * @date 2018-5-24 15:21:55
 */
@Entity
@Table(name = "auth_user")
public class User extends AbstractBean {
    /**
     * comment: 	主键
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    /**
     * comment: 	昵称
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	64
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * comment: 	用户名
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	32
     */
    @Column(name = "username")
    private String username;

    /**
     * comment: 	密码
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	64
     */
    @Column(name = "password")
    private String password;

    /**
     * comment: 	状态[0:未启用;1:启用]
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	1
     */
    @Column(name = "enabled")
    private Boolean enabled;

    /**
     * comment: 	锁定状态[0:未锁定;1:锁定]
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	1
     */
    @Column(name = "lock_status")
    private Boolean lockStatus;

    /**
     * comment: 	过期时间
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	19
     */
    @Column(name = "expired_date")
    private Date expiredDate;

    /**
     * comment: 	凭证过期时间
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	19
     */
    @Column(name = "credentials_expired_date")
    private Date credentialsExpiredDate;


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getLockStatus() {
        return lockStatus;
    }

    public User setLockStatus(Boolean lockStatus) {
        this.lockStatus = lockStatus;
        return this;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public User setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
        return this;
    }

    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public User setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
        return this;
    }
}