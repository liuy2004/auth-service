package xyz.liweichao.auth.core.properties.oauth;

import lombok.Data;

/**
 * JWT 签名密钥
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Data
public class OAuth2Properties {

    /**
     * 使用jwt时为token签名的秘钥
     */
    private String digitalSignature = "colors";

    /**
     * 使用redis时redis key 的前缀
     */
    private String prefix = "colors_auth_token_";
    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};

}
