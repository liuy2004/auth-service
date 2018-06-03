package xyz.liweichao.auth.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Filter;
import xyz.liweichao.auth.model.persistence.databinds.OrganizationDeserializer;
import xyz.liweichao.auth.model.persistence.databinds.OrganizationSerializer;

import javax.persistence.*;
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
@ToString(of={"id","name","code","layer"})
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * comment: 	组织机构代码（确保唯一）
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "code")
    private String code;

    /**
     * comment: 	层级
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	10
     */
    @Column(name = "layer")
    private Integer layer;

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
     * comment: 	父级 id
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */

    @JsonProperty("parent_id")
    @JsonSerialize(using = OrganizationSerializer.class)
    @JsonDeserialize(using = OrganizationDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "parent_id",foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Organization parent;

    /**
     * comment: 	路径（父节点 id 从高到低）
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	300
     */
    @Column(name = "path")
    private String path;


    /**
     * comment: 	描述
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	300
     */
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @OrderBy("sort desc")
    @JsonIgnoreProperties("children")
    private List<Organization> children;


    public Organization(Long id){
        this.id = id;
    }
}