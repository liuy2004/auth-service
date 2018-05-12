package xyz.liweichao.auth.core.social.support.exception;


import com.github.hicolors.colors.framework.core.common.exception.RestfulException;

/**
 * APP 模块异常
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class SocialUserNotFoundException extends RestfulException {

    public SocialUserNotFoundException(String msg) {
        super(msg);
    }

}
