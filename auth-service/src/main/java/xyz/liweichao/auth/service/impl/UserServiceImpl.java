package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.common.utils.BeanUtils;
import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.liweichao.auth.core.exception.UserNotFoundException;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.service.IColorsUserService;
import xyz.liweichao.auth.dao.*;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.persistence.UserRole;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;
import xyz.liweichao.auth.service.IUserDetailService;
import xyz.liweichao.auth.service.IUserService;

import java.util.*;

/**
 * UserServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */
@Service
public class UserServiceImpl extends AbstractService<User, Long> implements IUserService, IColorsUserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private IUserDetailService userDetailService;

    @Autowired
    private UserRoleGroupRepository userRoleGroupRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private RoleGroupRepository roleGroupRepository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public User queryUserByUniqueKey(String uniqueKey) {
        return repository.findByUsername(uniqueKey);
    }

    @Override
    public User loadUserAuthInfo(String uniqueKey) {
        User user = queryUserByUniqueKey(uniqueKey);
        if (Objects.nonNull(user)) {
            if (Objects.isNull(userDetailService.queryOne(user.getId()))) {
                throw new UserNotFoundException("当前账户的详细信息不存在！");
            }
        } else {
            UserDetail userDetail = userDetailService.queryByUniqueKey(uniqueKey);
            if (Objects.nonNull(userDetail)) {
                user = queryOne(userDetail.getId());
                if (Objects.isNull(user)) {
                    throw new UserNotFoundException("当前账户的认证信息不存在！");
                }
            } else {
                throw new UserNotFoundException("当前账户的信息不存在！");
            }
        }
        return user;
    }

    @Override
    public ColorsUser loadUserByUniqueKey(String uniqueKey) {
        ColorsUser colorsUser = new ColorsUser();
        User user = loadUserAuthInfo(uniqueKey);
        UserDetail userDetail = userDetailService.queryOne(user.getId());
        BeanUtils.copyProperties(user, colorsUser);
        BeanUtils.copyProperties(userDetail, colorsUser);
        colorsUser.setRoles(findAllRoles(user.getId()));
        return colorsUser;
    }

    private Set<String> findAllRoles(Long userId) {
        Set<String> roles = new HashSet<>();
        List<UserRoleGroup> userRoleGroups = userRoleGroupRepository.findByUserId(userId);
        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);
        userRoleGroups.forEach(e -> e.getRoleGroup().getRoles().forEach(e2 -> roles.add(e2.getCode())));
        userRoles.forEach(e -> roles.add(e.getRole().getCode()));
        return roles;
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public User roles(User user, ArrayList<Long> roles) {
        roleRepository.findByIdIsIn(roles).forEach(e -> {
                    UserRole userRole = new UserRole();
                    userRole.setUser(user);
                    userRole.setRole(e);
                    userRoleRepository.save(userRole);
                }
        );
        return user;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public User groups(User user, ArrayList<Long> groups) {
        roleGroupRepository.findByIdIsIn(groups).forEach(e -> {
                    UserRoleGroup userRoleGroup = new UserRoleGroup();
                    userRoleGroup.setUser(user);
                    userRoleGroup.setRoleGroup(e);
                    userRoleGroupRepository.save(userRoleGroup);
                }
        );
        return user;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteRoleGroup(User user, Long gid) {
        userRoleGroupRepository.deleteByUserIdAndRoleGroupId(user.getId(), gid);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteRole(User user, Long rid) {
        userRoleRepository.deleteByIdUserId(user.getId(), rid);
    }
}