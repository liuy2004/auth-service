package xyz.liweichao.auth.core.social.ways.qq.connet;


import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import xyz.liweichao.auth.core.social.ways.qq.api.QQ;

/**
 * QQ 链接工厂
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }

}
