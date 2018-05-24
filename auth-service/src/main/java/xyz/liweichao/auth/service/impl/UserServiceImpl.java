package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.service.IUserService;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements IUserService {

    @Autowired
    private UserDao dao;

    public UserServiceImpl(UserDao dao) {
        super(dao);
    }
}
