package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.abs.controller.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;

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
public interface IUserDetailApi extends Controller<UserDetail, Long> {

    @GetMapping("code/{type}")
    @ApiOperation("获取验证码")
    Map<String, Object> code(@PathVariable("type") String type, @RequestParam("unique") String unique);

    @PostMapping("/simple")
    @ApiOperation("注册用户")
    UserDetail register(@RequestBody RegisterModel model);

    @PatchMapping("/password")
    @ApiOperation(value = "修改密码", notes = "用户自己修改密码")
    UserDetail password(@RequestBody PasswordModel model);

    @PatchMapping("/{id}/password")
    @ApiOperation("修改密码")
    UserDetail restPassword(@PathVariable("id") Long id);

}