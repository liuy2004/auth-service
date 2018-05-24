package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserRoleGroupApi;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;
import xyz.liweichao.auth.service.IUserRoleGroupService;

@RestController
public class UserRoleGroupController extends AbstractController<UserRoleGroup, Long> implements IUserRoleGroupApi {

    @Autowired
    private IUserRoleGroupService service;

    public UserRoleGroupController(IUserRoleGroupService service) {
        super(service);
    }
}