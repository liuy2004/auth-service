package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.abs.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IRoleApi;
import xyz.liweichao.auth.model.persistence.Role;
import xyz.liweichao.auth.service.IRoleService;

import java.util.ArrayList;

/**
 * RoleController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class RoleController extends AbstractController<Role, Long> implements IRoleApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    private final IRoleService service;

    public RoleController(IRoleService service) {
        super(service);
        this.service = service;
    }

    @Override
    public Role users(@PathVariable("id") Long id, @RequestBody ArrayList<Long> users) {
        return service.users(query(id), users);
    }
}