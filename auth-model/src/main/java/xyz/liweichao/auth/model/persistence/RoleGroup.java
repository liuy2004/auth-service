package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.core.common.abs.AbstractBean;

import javax.persistence.*;

/**
 * comment:角色组信息
 *
 * @author liweichao
 * @date 2018-5-24 15:25:18
 */
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


    public Long getId() {
        return id;
    }

    public RoleGroup setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleGroup setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RoleGroup setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public RoleGroup setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}