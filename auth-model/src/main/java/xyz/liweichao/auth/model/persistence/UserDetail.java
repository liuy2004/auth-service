package xyz.liweichao.auth.model.persistence;

import com.github.hicolors.colors.framework.common.model.AbstractBean;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * comment:用户详细信息
 *
 * @author liweichao
 * @date 2018-5-24 15:26:05
 */

@Data
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
}