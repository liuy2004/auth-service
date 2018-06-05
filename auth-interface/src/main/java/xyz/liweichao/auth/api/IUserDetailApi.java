package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.common.controller.IController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.liweichao.auth.model.persistence.UserDetail;

import java.util.ArrayList;

/**
 * 对用户详细信息操作接口
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */
@Api(tags = "user-detail", description = "对用户详细信息操作接口")
@RequestMapping("user-detail")
public interface IUserDetailApi extends IController<UserDetail, Long> {

    @PostMapping("/{id}/roles")
    @ApiOperation("对用户赋权（赋予角色信息）")
    UserDetail roles(@PathVariable("id") Long id, @RequestBody ArrayList<Long> roles);

    @PostMapping("/{id}/role-groups")
    @ApiOperation("对用户赋权（赋予角色组信息，则自动具有该角色组下所有角色权限）")
    UserDetail groups(@PathVariable("id") Long id, @RequestBody ArrayList<Long> groups);


}