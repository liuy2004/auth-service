package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.AuthUserDetailDao;
import xyz.liweichao.auth.model.persistence.AuthUserDetail;
import xyz.liweichao.auth.service.IAuthUserDetailService;

@Service
public class AuthUserDetailServiceImpl extends AbstractService<AuthUserDetail, Long> implements IAuthUserDetailService {

    @Autowired
    private AuthUserDetailDao dao;

    public AuthUserDetailServiceImpl(AuthUserDetailDao dao) {
        super(dao);
    }
}
