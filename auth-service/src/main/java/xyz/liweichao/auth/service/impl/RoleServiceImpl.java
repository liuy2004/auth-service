package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.liweichao.auth.dao.RoleDao;
import xyz.liweichao.auth.dao.RoleGroupDao;
import xyz.liweichao.auth.exception.RoleException;
import xyz.liweichao.auth.exception.RoleExceptionEnum;
import xyz.liweichao.auth.model.persistence.Role;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.service.IRoleService;

import java.util.Objects;

/**
 * RoleServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, Long> implements IRoleService {

    @Autowired
    private RoleGroupDao roleGroupDao;

    public RoleServiceImpl(RoleDao dao) {
        super(dao);
    }

    private Role buildParam(Role bean) {
        if (Objects.nonNull(bean.getRoleGroup()) && Objects.nonNull(bean.getRoleGroup().getId())) {
            Long id = bean.getRoleGroup().getId();
            if (Objects.isNull(roleGroupDao.findOne(id))) {
                throw new RoleException(RoleExceptionEnum.GOURP_NOT_FOUNT, id);
            }
        } else {
            bean.setRoleGroup(new RoleGroup(1L));
        }
        return bean;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Role save(Role bean) {
        return super.save(buildParam(bean));
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Role update(Role bean) {
        return super.save(buildParam(bean));
    }

}