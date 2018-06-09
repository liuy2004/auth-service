package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.Role;

/**
 * RoleDao
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/4
 */
@Repository
public interface RoleRepository extends IRepository<Role, Long> {

    /**
     * 通过角色代码查询
     *
     * @param code
     * @return
     */
    Role findByCode(String code);
}