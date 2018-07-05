package xyz.liweichao.auth.model.persistence;


import com.github.hicolors.colors.framework.model.bean.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * comment: 用户角色组关联信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:41
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "auth_user_role_group")
@ToString(exclude = "user")
public class UserRoleGroup extends AbstractBean {
    /**
     * comment: 	主键
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * comment: 	角色组 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */

    @OneToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private RoleGroup roleGroup;

    /**
     * comment: 	用户 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private User user;
}