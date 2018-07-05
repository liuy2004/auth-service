package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.abs.controller.Controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;

/**
 * 对用户角色组关联信息操作接口
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/12
 */
@Api(tags = "user-role-group", description = "对用户角色组关联信息操作接口")
@RequestMapping("user-role-group")
public interface IUserRoleGroupApi extends Controller<UserRoleGroup, Long> {
}