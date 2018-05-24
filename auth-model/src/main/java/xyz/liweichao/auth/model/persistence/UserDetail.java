package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.core.common.abs.AbstractBean;

import javax.persistence.*;
import java.util.Date;

/**
 * comment:用户详细信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:05
 */
@Entity
@Table(name = "auth_user_detail")
public class UserDetail extends AbstractBean {
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
     * comment: 	邮箱
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	50
     */
    @Column(name = "email")
    private String email;

    /**
     * comment: 	手机号
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * comment: 	姓名
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @Column(name = "name")
    private String name;

    /**
     * comment: 	出生日期
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	19
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * comment: 	描述
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	255
     */
    @Column(name = "description")
    private String description;

    /**
     * comment: 	主页
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	50
     */
    @Column(name = "website")
    private String website;

    /**
     * comment: 	头像
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	150
     */
    @Column(name = "favicon")
    private String favicon;

    public Long getId() {
        return id;
    }

    public UserDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDetail setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserDetail setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDetail setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserDetail setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserDetail setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public UserDetail setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getFavicon() {
        return favicon;
    }

    public UserDetail setFavicon(String favicon) {
        this.favicon = favicon;
        return this;
    }
}