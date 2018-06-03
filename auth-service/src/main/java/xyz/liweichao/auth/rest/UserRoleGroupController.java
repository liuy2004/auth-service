package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserRoleGroupApi;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;
import xyz.liweichao.auth.service.IUserRoleGroupService;


/**
 * UserRoleGroupController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class UserRoleGroupController extends AbstractController<UserRoleGroup, Long> implements IUserRoleGroupApi {

    public UserRoleGroupController(IUserRoleGroupService service) {
        super(service);
    }
}