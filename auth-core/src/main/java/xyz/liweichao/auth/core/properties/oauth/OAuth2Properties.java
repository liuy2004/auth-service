package xyz.liweichao.auth.core.properties.oauth;

/**
 * JWT 签名密钥
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class OAuth2Properties {

    /**
     * 使用jwt时为token签名的秘钥
     */
    private String digitalSignature = "colors";

    /**
     * 使用redis时redis key 的前缀
     */
    private String prefix = "colors_token_";
    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public OAuth2Properties setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public OAuth2Properties setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }
}
