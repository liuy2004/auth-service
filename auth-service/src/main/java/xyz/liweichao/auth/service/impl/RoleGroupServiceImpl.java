package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.liweichao.auth.dao.RoleGroupRepository;
import xyz.liweichao.auth.dao.UserRepository;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;
import xyz.liweichao.auth.service.IRoleGroupService;
import xyz.liweichao.auth.service.IUserRoleGroupService;

import java.util.ArrayList;

/**
 * RoleGroupServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/24
 */

@Service
public class RoleGroupServiceImpl extends AbstractService<RoleGroup, Long> implements IRoleGroupService {

    private final RoleGroupRepository repository;

    @Autowired
    private IUserRoleGroupService userRoleGroupService;

    @Autowired
    private UserRepository userRepository;

    public RoleGroupServiceImpl(RoleGroupRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public RoleGroup users(RoleGroup roleGroup, ArrayList<Long> users) {
        userRepository.findByIdIsIn(users).forEach(e -> {
            UserRoleGroup userRoleGroup = new UserRoleGroup();
            userRoleGroup.setRoleGroup(roleGroup);
            userRoleGroup.setUser(e);
            userRoleGroupService.save(userRoleGroup);
        });
        return roleGroup;
    }
}