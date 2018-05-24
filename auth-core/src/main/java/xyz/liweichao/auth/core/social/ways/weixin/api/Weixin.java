package xyz.liweichao.auth.core.social.ways.weixin.api;

/**
 * 微信API调用接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);

}
