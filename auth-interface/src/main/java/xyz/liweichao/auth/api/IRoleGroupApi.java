package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.abs.controller.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.liweichao.auth.model.persistence.RoleGroup;

import java.util.ArrayList;

/**
 * 对角色组信息操作接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */

@Api(tags = "role-group", description = "对角色组信息操作接口")
@RequestMapping("role-group")
public interface IRoleGroupApi extends Controller<RoleGroup, Long> {

    @PostMapping("/{id}/users-details")
    @ApiOperation("绑定用户（绑定用户具有该角色组权限）")
    RoleGroup users(@PathVariable("id") Long id, @RequestBody ArrayList<Long> users);

}