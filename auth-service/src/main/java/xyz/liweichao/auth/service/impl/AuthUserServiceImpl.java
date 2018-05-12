package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.AuthUserDao;
import xyz.liweichao.auth.model.persistence.AuthUser;
import xyz.liweichao.auth.service.IAuthUserService;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUser, Long> implements IAuthUserService {

    @Autowired
    private AuthUserDao dao;

    public AuthUserServiceImpl(AuthUserDao dao) {
        super(dao);
    }
}
