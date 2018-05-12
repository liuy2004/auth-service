package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.core.common.abs.AbstractBean;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * comment: 用户详细信息
 *
 * @author liweichao
 * @date 2018-5-12 10:57:25
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "auth_user_detail")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties({"hibernate_lazy_initializer", "handler", "hospitalGuides"})
public class AuthUserDetail extends AbstractBean {
    /**
     * comment: 	主键
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @javax.persistence.Column(name = "id")
    @javax.persistence.Id
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "assigned")
    private Long id;

    /**
     * comment: 	邮箱
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	50
     */
    @javax.persistence.Column(name = "email")
    private String email;

    /**
     * comment: 	手机号
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @javax.persistence.Column(name = "mobile")
    private String mobile;

    /**
     * comment: 	姓名
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     */
    @javax.persistence.Column(name = "name")
    private String name;

    /**
     * comment: 	出生日期
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	19
     */
    @javax.persistence.Column(name = "birthday")
    private Date birthday;

    /**
     * comment: 	描述
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	255
     */
    @javax.persistence.Column(name = "description")
    private String description;

    /**
     * comment: 	主页
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	50
     */
    @javax.persistence.Column(name = "website")
    private String website;

    /**
     * comment: 	头像
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	150
     */
    @javax.persistence.Column(name = "favicon")
    private String favicon;

    public Long getId() {
        return id;
    }

    public AuthUserDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AuthUserDetail setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public AuthUserDetail setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthUserDetail setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public AuthUserDetail setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuthUserDetail setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public AuthUserDetail setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getFavicon() {
        return favicon;
    }

    public AuthUserDetail setFavicon(String favicon) {
        this.favicon = favicon;
        return this;
    }
}