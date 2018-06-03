package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IRoleApi;
import xyz.liweichao.auth.model.persistence.Role;
import xyz.liweichao.auth.service.IRoleService;

/**
 * RoleController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class RoleController extends AbstractController<Role, Long> implements IRoleApi {

    public RoleController(IRoleService service) {
        super(service);
    }
}