package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IRoleApi;
import xyz.liweichao.auth.model.persistence.Role;
import xyz.liweichao.auth.service.IRoleService;

@RestController
public class RoleController extends AbstractController<Role, Long> implements IRoleApi {

    @Autowired
    private IRoleService service;

    public RoleController(IRoleService service) {
        super(service);
    }
}