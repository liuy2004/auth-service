package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * comment: 角色信息
 *
 * @author liweichao
 * @date 2018-5-24 16:43:57
 */

@Entity
@Table(name = "auth_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends AbstractBean {
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
     * comment: 	名称
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "name")
    private String name;

    /**
     * comment: 	角色代码
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "code")
    private String code;

    /**
     * comment: 	默认排序字段
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	10
     */
    @Column(name = "sort")
    private Integer sort;

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
}