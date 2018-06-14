package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.abs.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IRoleGroupApi;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.service.IRoleGroupService;

import java.util.ArrayList;

/**
 * RoleGroupController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class RoleGroupController extends AbstractController<RoleGroup, Long> implements IRoleGroupApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleGroupController.class);

    private final IRoleGroupService service;

    public RoleGroupController(IRoleGroupService service) {
        super(service);
        this.service = service;
    }

    @Override
    public RoleGroup users(@PathVariable("id") Long id, @RequestBody ArrayList<Long> users) {
        return service.users(query(id), users);
    }
}