package xyz.liweichao.auth.model.persistence;


import com.github.hicolors.colors.framework.model.bean.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * comment:用户角色关联信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:23
 */
@Entity
@Table(name = "auth_user_role")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "user")
public class UserRole extends AbstractBean {
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
     * comment: 	角色 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @OneToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Role role;

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