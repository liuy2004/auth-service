package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserDetailApi;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;

/**
 * UserDetailController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class UserDetailController extends AbstractController<UserDetail, Long> implements IUserDetailApi {

    public UserDetailController(IUserDetailService service) {
        super(service);
    }
}
