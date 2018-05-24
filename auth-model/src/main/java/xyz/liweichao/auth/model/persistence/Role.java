package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.core.common.abs.AbstractBean;

import javax.persistence.*;

/**
 * comment: 角色信息
 *
 * @author liweichao
 * @date 2018-5-24 16:43:57
 */
@Entity
@Table(name = "auth_role")
public class Role extends AbstractBean {
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
    @Column(name = "group_id")
    private Long groupId;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Role setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Role setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Role setGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }
}