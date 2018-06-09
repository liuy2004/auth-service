package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.UserRoleRepository;
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

    public UserRoleServiceImpl(UserRoleRepository repository) {
        super(repository);
    }
}