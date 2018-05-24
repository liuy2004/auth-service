package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserDetailApi;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;


@RestController
public class UserDetailController extends AbstractController<UserDetail, Long> implements IUserDetailApi {

    @Autowired
    private IUserDetailService service;

    public UserDetailController(IUserDetailService service) {
        super(service);
    }
}
