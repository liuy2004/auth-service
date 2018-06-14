package xyz.liweichao.auth.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.hicolors.colors.framework.common.model.AbstractBean;
import com.github.hicolors.colors.framework.common.valid.ValidatorGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import xyz.liweichao.auth.model.persistence.databinds.OrganizationDeserializer;
import xyz.liweichao.auth.model.persistence.databinds.OrganizationSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * comment: 组织机构信息
 *
 * @author liweichao
 * @date 2018-5-24 15:24:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(exclude = {"parent", "children"})
@Entity
@Table(name = "auth_organization")
public class Organization extends AbstractBean {
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
     * comment: 	全称
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Null(
            message = "display_name 必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
    @Column(name = "display_name")
    private String displayName;

    /**
     * comment: 	组织机构代码（确保唯一）
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
     * comment: 	层级
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	10
     */
    @Null(
            message = "layer[层级]必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
    @Column(name = "layer")
    private Integer layer;

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
     * comment: 	父级 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @NotNull(
            message = "父级 ID 不能为空",
            groups = {ValidatorGroup.Post.class}
    )
    @JsonSerialize(using = OrganizationSerializer.class)
    @JsonDeserialize(using = OrganizationDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Organization parent;

    /**
     * comment: 	路径（父节点 id 从高到低）
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	300
     */
    @Null(
            message = "path[路径]必须为空",
            groups = {ValidatorGroup.Post.class, ValidatorGroup.Put.class, ValidatorGroup.Patch.class}
    )
    @Column(name = "path")
    private String path;


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


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @OrderBy("sort desc")
    @JsonIgnoreProperties("children")
    private List<Organization> children;


    public Organization(Long id) {
        this.id = id;
    }
}