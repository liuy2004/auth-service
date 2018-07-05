package xyz.liweichao.auth.core.rbac;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.properties.SecurityProperties;
import xyz.liweichao.auth.core.service.IColorsUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 权限表达式实现
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/14
 */
@Service("defaultRbacExpression")
public class DefaultRbacExpression implements RbacExpression {

    private static final String ANONYMOUSUSER = "anonymoususer";
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private IColorsUserService colorsUserService;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public boolean hasPermission(Authentication authentication, HttpServletRequest request) {

        if (!securityProperties.getEnable()) {
            return true;
        }

        Object principal = authentication.getPrincipal();

        boolean hasPermission = false;

        if (((String) principal).equalsIgnoreCase(ANONYMOUSUSER)) {
            return false;
        }

        principal = colorsUserService.loadUserByUniqueKey(String.valueOf(principal));

        if (principal != null) {
            // 判断是否是管理员
            if (StringUtils.equals(((ColorsUser) principal).getUsername(), securityProperties.getSu())) {
                hasPermission = true;
            } else {
                //TODO 此处应该是读取用户所拥有权限的所有URL
                Set<String> urls = Sets.newHashSet("/**");
                for (String url : urls) {
                    if (antPathMatcher.match(url, request.getRequestURI())) {
                        hasPermission = true;
                        break;
                    }
                }
            }
        }

        return hasPermission;
    }
}