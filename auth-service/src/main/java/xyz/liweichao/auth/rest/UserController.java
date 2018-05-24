package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserApi;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.service.IUserService;

@RestController
public class UserController extends AbstractController<User, Long> implements IUserApi {

    @Autowired
    private IUserService service;

    public UserController(IUserService service) {
        super(service);
    }

}
