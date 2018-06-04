package xyz.liweichao.auth.model.persistence;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.hicolors.colors.framework.common.model.AbstractBean;
import com.github.hicolors.colors.framework.common.valid.ValidatorGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import xyz.liweichao.auth.model.persistence.databinds.RoleGroupDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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
@NoArgsConstructor
public class Role extends AbstractBean {
    /**
     * comment: 	主键
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Null(
            message = "id 必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
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
    @NotNull(
            message = "name[名称]不能为空",
            groups = {ValidatorGroup.Post.class}
    )
    @Column(name = "name")
    private String name;

    /**
     * comment: 	角色代码
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @NotNull(
            message = "code[代码]不能为空",
            groups = {ValidatorGroup.Post.class}
    )
    @Column(name = "code")
    private String code;

    /**
     * comment: 	默认排序字段
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	10
     */
    @NotNull(
            message = "sort[排序号]不能为空",
            groups = {ValidatorGroup.Post.class}
    )
    @Column(name = "sort")
    private Integer sort;

    /**
     * comment: 	角色组 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */

    @JsonDeserialize(using = RoleGroupDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private RoleGroup roleGroup;

    /**
     * comment: 	描述
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	300
     */
    @NotNull(
            message = "description[描述]不能为空",
            groups = {ValidatorGroup.Post.class}
    )
    @Column(name = "description")
    private String description;
}