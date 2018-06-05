package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.dao.UserRoleGroupDao;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;
import xyz.liweichao.auth.service.IUserRoleGroupService;


/**
 * UserRoleGroupServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class UserRoleGroupServiceImpl extends AbstractService<UserRoleGroup, Long> implements IUserRoleGroupService {

    @Autowired
    private UserRoleGroupDao dao;

    public UserRoleGroupServiceImpl(UserDao dao) {
        super(dao);
    }
}