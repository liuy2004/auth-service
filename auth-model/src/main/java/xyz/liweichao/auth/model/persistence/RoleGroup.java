package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * comment:角色组信息
 *
 * @author liweichao
 * @date 2018-5-24 15:25:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "auth_role_group")
public class RoleGroup extends AbstractBean {
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
     * comment: 	角色组代码
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

    public RoleGroup(Long id) {
        this.id = id;
    }
}