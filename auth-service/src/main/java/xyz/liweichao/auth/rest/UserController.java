package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserApi;
import xyz.liweichao.auth.core.exception.AuthServiceException;
import xyz.liweichao.auth.handler.Demo;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.service.IUserService;

@RestController
public class UserController extends AbstractController<User, Long> implements IUserApi {

    @Autowired
    private IUserService service;

    public UserController(IUserService service) {
        super(service);
    }

    @GetMapping("test")
    public Demo test() {
        throw new AuthServiceException(HttpStatus.BAD_REQUEST,1234567L,"测试异常", new Demo());
    }

}
