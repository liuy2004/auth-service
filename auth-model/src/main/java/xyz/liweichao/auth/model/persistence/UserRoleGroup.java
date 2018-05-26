package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;

import javax.persistence.*;

/**
 * comment: 用户角色组关联信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:41
 */
@Entity
@Table(name = "auth_user_role_group")
public class UserRoleGroup extends AbstractBean {
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
     * comment: 	角色组 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "group_id")
    private Long groupId;

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

    public UserRoleGroup setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getGroupId() {
        return groupId;
    }

    public UserRoleGroup setGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRoleGroup setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}