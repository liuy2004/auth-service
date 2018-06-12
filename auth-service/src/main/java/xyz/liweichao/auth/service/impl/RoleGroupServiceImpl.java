package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.liweichao.auth.dao.RoleGroupRepository;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;
import xyz.liweichao.auth.service.IRoleGroupService;
import xyz.liweichao.auth.service.IUserRoleGroupService;
import xyz.liweichao.auth.service.IUserService;

import java.util.ArrayList;

/**
 * RoleGroupServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/24
 */

@Service
public class RoleGroupServiceImpl extends AbstractService<RoleGroup, Long> implements IRoleGroupService {

    private RoleGroupRepository repository;

    @Autowired
    private IUserRoleGroupService userRoleGroupService;

    @Autowired
    private IUserService userService;

    public RoleGroupServiceImpl(RoleGroupRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public RoleGroup users(Long id, ArrayList<Long> users) {
        RoleGroup roleGroup = repository.findOne(id);
        users.forEach(e -> {
            UserRoleGroup userRoleGroup = new UserRoleGroup();
            userRoleGroup.setUser(userService.queryOne(e));
            userRoleGroup.setRoleGroup(roleGroup);
            userRoleGroupService.save(userRoleGroup);
        });
        return roleGroup;
    }
}