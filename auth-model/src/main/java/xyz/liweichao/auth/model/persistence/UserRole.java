package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;

import javax.persistence.*;

/**
 * comment:用户角色关联信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:23
 */
@Entity
@Table(name = "auth_user_role")
public class UserRole extends AbstractBean {
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
     * comment: 	角色 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * comment: 	用户 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "user_id")
    private Long userId;


    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public UserRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}