package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * comment: 用户认证信息
 *
 * @author liweichao
 * @date 2018-5-24 15:21:55
 */
@Data
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
}