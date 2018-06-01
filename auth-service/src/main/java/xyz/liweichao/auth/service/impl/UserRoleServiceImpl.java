package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.dao.UserRoleDao;
import xyz.liweichao.auth.model.persistence.UserRole;
import xyz.liweichao.auth.service.IUserRoleService;

/**
 * UserRoleServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole, Long> implements IUserRoleService {

    @Autowired
    private UserRoleDao dao;

    public UserRoleServiceImpl(UserRoleDao dao) {
        super(dao);
    }
}