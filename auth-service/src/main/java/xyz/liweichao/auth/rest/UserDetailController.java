package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.abs.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailController.class);

    private final IUserDetailService service;

    public UserDetailController(IUserDetailService service) {
        super(service);
        this.service = service;
    }

    @Override
    public Map<String, Object> code(@PathVariable("type") String type, @RequestParam String uniqueKey) {
        return null;
    }

    @Override
    public UserDetail register(@RequestBody RegisterModel model) {
        return service.register(model);
    }

    @Override
    public UserDetail password(@RequestBody PasswordModel model) {
        return service.modifyPasswordOnValid(model);
    }

    @Override
    public UserDetail restPassword(@PathVariable("id") Long id) {
        return service.resetPassword(query(id));
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
