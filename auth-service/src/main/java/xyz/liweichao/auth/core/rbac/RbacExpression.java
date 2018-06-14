package xyz.liweichao.auth.core.rbac;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 基于角色的权限表达式
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/14
 */
public interface RbacExpression {

    /**
     * 是否拥有权限
     *
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(Authentication authentication, HttpServletRequest request);

}
