package xyz.liweichao.auth.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * ColorsUser
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */
@Data
@NoArgsConstructor
public class ColorsUser {

    private Long id;

    /**
     * comment: 	昵称
     */
    private String nickName;

    /**
     * comment: 	用户名
     */
    private String username;

    /**
     * comment: 	状态[0:未启用;1:启用]
     */
    private Boolean enabled;

    /**
     * comment: 	锁定状态[0:未锁定;1:锁定]
     */
    private Boolean lockStatus;

    /**
     * comment: 	过期时间
     */
    private Date expiredDate;

    /**
     * comment: 	凭证过期时间
     */
    private Date credentialsExpiredDate;

    /**
     * comment: 	邮箱
     */
    private String email;

    /**
     * comment: 	手机号
     */
    private String mobile;

    /**
     * comment: 	姓名
     */
    private String name;

    /**
     * comment: 	出生日期
     */
    private Date birthday;

    /**
     * comment: 	描述
     */
    private String description;

    /**
     * comment: 	主页
     */
    private String website;

    /**
     * comment: 	头像
     */
    private String favicon;

    /**
     * 角色
     */
    private List<String> roles;

}
