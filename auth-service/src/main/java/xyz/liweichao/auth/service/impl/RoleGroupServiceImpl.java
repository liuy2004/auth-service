package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.RoleGroupDao;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.service.IRoleGroupService;

@Service
public class RoleGroupServiceImpl extends AbstractService<RoleGroup, Long> implements IRoleGroupService {

    @Autowired
    private RoleGroupDao dao;

    public RoleGroupServiceImpl(UserDao dao) {
        super(dao);
    }
}