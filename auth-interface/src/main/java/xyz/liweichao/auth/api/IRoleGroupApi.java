package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.core.common.abs.intf.IController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.liweichao.auth.model.persistence.RoleGroup;

/**
 * 对角色组信息操作接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */

@Api(tags = "role-group", description = "对角色组信息操作接口")
@RequestMapping("role-group")
public interface IRoleGroupApi extends IController<RoleGroup, Long> {
}
