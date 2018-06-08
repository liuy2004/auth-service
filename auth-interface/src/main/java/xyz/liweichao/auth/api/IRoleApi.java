package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.common.controller.IController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz.liweichao.auth.model.persistence.Role;

import java.util.ArrayList;

/**
 * 对角色信息操作接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */

@Api(tags = "role", description = "对角色信息操作接口")
@RequestMapping("role")
public interface IRoleApi extends IController<Role, Long> {

    @PostMapping("/{id}/users-details")
    @ApiOperation("绑定用户（绑定用户具有该角色权限）")
    Role users(@PathVariable("id") Long id, @RequestBody ArrayList<Long> users);
}