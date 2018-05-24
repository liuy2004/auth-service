package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IRoleGroupApi;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.service.IRoleGroupService;

@RestController
public class RoleGroupController extends AbstractController<RoleGroup, Long> implements IRoleGroupApi {

    @Autowired
    private IRoleGroupService service;

    public RoleGroupController(IRoleGroupService service) {
        super(service);
    }
}