package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import com.github.hicolors.colors.framework.core.others.jackson.annotation.JsonBeanFilter;
import com.github.hicolors.colors.framework.core.others.jackson.annotation.JsonResultFilter;
import com.github.hicolors.colors.framework.core.others.jpa.expression.ColorsExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IAuthUserApi;
import xyz.liweichao.auth.model.persistence.AuthUser;
import xyz.liweichao.auth.service.IAuthUserService;

import java.util.List;

@RestController
@RequestMapping("auth-user")
public class AuthUserController extends AbstractController<AuthUser, Long> implements IAuthUserApi {

    @Autowired
    private IAuthUserService service;

    public AuthUserController(IAuthUserService service) {
        super(service);
    }

    @Override
    @GetMapping
    @JsonResultFilter(values = {
            @JsonBeanFilter(clazz = AuthUser.class,excludes = {"id"})
    })
    public Page<AuthUser> paging(Pageable pageable, List<ColorsExpression> filters) {
        return this.service.queryPage(pageable, filters);
    }
}
