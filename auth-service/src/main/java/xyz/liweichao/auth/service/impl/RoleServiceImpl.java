package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.RoleDao;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.model.persistence.Role;
import xyz.liweichao.auth.service.IRoleService;

@Service
public class RoleServiceImpl extends AbstractService<Role, Long> implements IRoleService {

    @Autowired
    private RoleDao dao;

    public RoleServiceImpl(UserDao dao) {
        super(dao);
    }
}