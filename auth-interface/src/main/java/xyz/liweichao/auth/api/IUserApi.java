package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.abs.controller.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz.liweichao.auth.model.persistence.User;

import java.util.ArrayList;

/**
 * 对用户认证信息操作接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */

@Api(tags = "user", description = "对用户认证信息操作接口")
@RequestMapping("user")
public interface IUserApi extends Controller<User, Long> {

    @PostMapping("/{id}/roles")
    @ApiOperation("对用户赋权（赋予角色信息）")
    User roles(@PathVariable("id") Long id, @RequestBody ArrayList<Long> roles);

    @PostMapping("/{id}/role-groups")
    @ApiOperation("对用户赋权（赋予角色组信息，则自动具有该角色组下所有角色权限）")
    User groups(@PathVariable("id") Long id, @RequestBody ArrayList<Long> groups);

    @DeleteMapping("/{id}/role-group/{gid}")
    @ApiOperation("删除用户角色组权限")
    void deleteRoleGroup(@PathVariable("id") Long id, @PathVariable("gid") Long gid);

    @DeleteMapping("/{id}/role/{rid}")
    @ApiOperation("删除用户角色权限")
    void deleteRole(@PathVariable("id") Long id, @PathVariable("rid") Long rid);
}
