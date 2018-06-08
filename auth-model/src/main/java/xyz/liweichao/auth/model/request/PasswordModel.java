package xyz.liweichao.auth.model.request;

import lombok.Data;

/**
 * 修改密码模型
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/6
 */
@Data
public class PasswordModel {

    /**
     * 新密码
     */
    private String password;

    /**
     * 旧密码
     */
    private String oldPassword;
}
