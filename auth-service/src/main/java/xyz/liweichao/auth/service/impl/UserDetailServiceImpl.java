package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.UserDetailDao;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;

@Service
public class UserDetailServiceImpl extends AbstractService<UserDetail, Long> implements IUserDetailService {

    @Autowired
    private UserDetailDao dao;

    public UserDetailServiceImpl(UserDetailDao dao) {
        super(dao);
    }
}
