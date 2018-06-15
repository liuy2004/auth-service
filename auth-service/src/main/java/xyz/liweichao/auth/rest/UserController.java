package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.abs.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserApi;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.service.IUserService;

import java.util.ArrayList;

/**
 * UserController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class UserController extends AbstractController<User, Long> implements IUserApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final IUserService service;

    public UserController(IUserService service) {
        super(service);
        this.service = service;
    }

    @Override
    public User roles(@PathVariable("id") Long id, @RequestBody ArrayList<Long> roles) {
        return service.roles(query(id), roles);
    }
    @Override
    public User groups(@PathVariable("id") Long id, @RequestBody ArrayList<Long> groups) {
        return service.groups(query(id), groups);
    }

    @Override
    public User deleteRoleGroup(@PathVariable("id") Long id, @PathVariable("gid") Long gid) {
        return service.deleteRoleGroup(id, gid);
    }

    @Override
    public User deleteRole(@PathVariable("id") Long id, @PathVariable("rid") Long rid) {
        return service.deleteRole(id, rid);
    }
}
