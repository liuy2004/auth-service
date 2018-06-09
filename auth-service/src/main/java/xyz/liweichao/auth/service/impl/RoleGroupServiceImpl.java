package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.RoleGroupRepository;
import xyz.liweichao.auth.model.persistence.RoleGroup;
import xyz.liweichao.auth.service.IRoleGroupService;

/**
 * RoleGroupServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/24
 */

@Service
public class RoleGroupServiceImpl extends AbstractService<RoleGroup, Long> implements IRoleGroupService {

    public RoleGroupServiceImpl(RoleGroupRepository repository) {
        super(repository);
    }
}