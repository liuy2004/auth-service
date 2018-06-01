package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * comment: 组织机构信息
 *
 * @author liweichao
 * @date 2018-5-24 15:24:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
     * comment: 	级别
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	10
     */
    @Column(name = "level")
    private Integer level;

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
    @OneToOne
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Organization parent;

    /**
     * comment: 	父级所有代码简称拼接[分割符;]
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	300
     */
    @Column(name = "parent_codes")
    private String parentCodes;
}