package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserDetailApi;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;
import xyz.liweichao.auth.service.IUserDetailService;

import java.util.ArrayList;
import java.util.Map;

/**
 * UserDetailController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class UserDetailController extends AbstractController<UserDetail, Long> implements IUserDetailApi {

    public UserDetailController(IUserDetailService service) {
        super(service);
    }

    @Override
    public Map<String, Object> code(@PathVariable("type") String type, @RequestParam String uniqueKey) {
        return null;
    }

    @Override
    public UserDetail register(@RequestBody RegisterModel model) {
        return null;
    }

    @Override
    public UserDetail password(@AuthenticationPrincipal UserDetails user, @RequestBody PasswordModel model) {
        return null;
    }

    @Override
    public UserDetail restPassword(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public UserDetail roles(@PathVariable("id") Long id, @RequestBody ArrayList<Long> roles) {
        return null;
    }

    @Override
    public UserDetail groups(@PathVariable("id") Long id, @RequestBody ArrayList<Long> groups) {
        return null;
    }

    @Override
    public UserDetail deleteRoleGroup(@PathVariable("id") Long id, @PathVariable("gid") Long gid) {
        return null;
    }

    @Override
    public UserDetail deleteRole(@PathVariable("id") Long id, @PathVariable("rid") Long rid) {
        return null;
    }

}
