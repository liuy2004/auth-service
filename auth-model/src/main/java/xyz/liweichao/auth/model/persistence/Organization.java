package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;

import javax.persistence.*;

/**
 * comment: 组织机构信息
 *
 * @author liweichao
 * @date 2018-5-24 15:24:53
 */
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
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * comment: 	父级所有代码简称拼接[分割符;]
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	300
     */
    @Column(name = "parent_codes")
    private String parentCodes;

    public Long getId() {
        return id;
    }

    public Organization setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organization setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Organization setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Organization setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Organization setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public Organization setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getParentCodes() {
        return parentCodes;
    }

    public Organization setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
        return this;
    }
}