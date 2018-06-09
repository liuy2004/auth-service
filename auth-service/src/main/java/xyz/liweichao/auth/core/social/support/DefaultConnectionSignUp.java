package xyz.liweichao.auth.core.social.support;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * 根据社交用户信息默认创建用户并返回用户唯一标识
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/10
 */
@Component
public class DefaultConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }

}