package xyz.liweichao.auth.core.social.support.exception;


import xyz.liweichao.auth.core.exception.AuthException;

/**
 * APP 模块异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class SocialUserNotFoundException extends AuthException {

    public SocialUserNotFoundException(String msg) {
        super(msg);
    }

}
