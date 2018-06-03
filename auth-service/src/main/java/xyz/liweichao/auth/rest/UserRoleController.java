package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserRoleApi;
import xyz.liweichao.auth.model.persistence.UserRole;
import xyz.liweichao.auth.service.IUserRoleService;

/**
 * UserRoleController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class UserRoleController extends AbstractController<UserRole, Long> implements IUserRoleApi {

    public UserRoleController(IUserRoleService service) {
        super(service);
    }
}