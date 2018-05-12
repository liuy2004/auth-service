package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IAuthUserDetailApi;
import xyz.liweichao.auth.model.persistence.AuthUserDetail;
import xyz.liweichao.auth.service.IAuthUserDetailService;


@RestController
public class AuthUserDetailController extends AbstractController<AuthUserDetail, Long> implements IAuthUserDetailApi {

    @Autowired
    private IAuthUserDetailService service;

    public AuthUserDetailController(IAuthUserDetailService service) {
        super(service);
    }
}
