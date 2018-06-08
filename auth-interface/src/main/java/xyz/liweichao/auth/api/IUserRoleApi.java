package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.common.controller.IController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.liweichao.auth.model.persistence.UserRole;

/**
 * 对用户角色组关联信息操作接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */

@Api(tags = "user-role", description = "对用户角色关联信息操作接口")
@RequestMapping("/user-role")
public interface IUserRoleApi extends IController<UserRole, Long> {
}