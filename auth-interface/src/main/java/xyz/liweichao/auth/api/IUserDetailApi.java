package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.common.controller.IController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;

import java.util.ArrayList;
import java.util.Map;

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

    @GetMapping("code/{type}")
    @ApiOperation("获取验证码")
    Map<String, Object> code(@PathVariable("type") String type, @RequestParam("unique-key") String uniqueKey);

    @PostMapping("/simple")
    @ApiOperation("注册用户")
    UserDetail register(@RequestBody RegisterModel model);

    @PatchMapping("/{id}/password")
    @ApiOperation("修改密码")
    UserDetail password(@PathVariable("id") Long id, @RequestBody PasswordModel model);

    @PostMapping("/{id}/roles")
    @ApiOperation("对用户赋权（赋予角色信息）")
    UserDetail roles(@PathVariable("id") Long id, @RequestBody ArrayList<Long> roles);

    @PostMapping("/{id}/role-groups")
    @ApiOperation("对用户赋权（赋予角色组信息，则自动具有该角色组下所有角色权限）")
    UserDetail groups(@PathVariable("id") Long id, @RequestBody ArrayList<Long> groups);

}