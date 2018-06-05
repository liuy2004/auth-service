package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
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

    public RoleGroupController(IRoleGroupService service) {
        super(service);
    }

    @Override
    public RoleGroup users(@PathVariable("id") Long id, @RequestBody ArrayList<Long> users) {
        return null;
    }
}