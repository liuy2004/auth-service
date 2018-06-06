package xyz.liweichao.auth.model.request;

/**
 * 注册模型
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/6
 */
public class RegisterModel {

    /**
     * 唯一约束（手机号 或者 邮箱）
     */
    private String uniqueKey;

    /**
     * 验证码
     */
    private String code;
}
