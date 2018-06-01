package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.RoleDao;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.model.persistence.Role;
import xyz.liweichao.auth.service.IRoleService;

/**
 * RoleServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, Long> implements IRoleService {

    public RoleServiceImpl(UserDao dao) {
        super(dao);
    }
}