package xyz.liweichao.auth.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import xyz.liweichao.auth.model.persistence.databinds.RoleGroupDeserializer;

import javax.persistence.*;
import java.util.Date;

/**
 * comment:用户详细信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:05
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "auth_user_detail")
public class UserDetail extends AbstractBean {
    /**
     * comment: 	主键
     * <p>
     * isNullable: 	false
     * <p>
     * length: 	20
     *
     * 说明：此种方式 id 需要手动设置
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "assigned")
    private Long id;

    @OneToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Organization organization;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnoreProperties("password")
    private User user;
}