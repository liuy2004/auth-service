package xyz.liweichao.auth.dao;


import com.github.hicolors.colors.framework.core.abs.Repository;
import xyz.liweichao.auth.model.persistence.Role;

import java.util.List;

/**
 * RoleDao
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/4
 */
@org.springframework.stereotype.Repository
public interface RoleRepository extends Repository<Role, Long> {

    /**
     * 通过角色代码查询
     *
     * @param code
     * @return
     */
    Role findByCode(String code);

    List<Role> findByIdIsIn(List<Long> ids);
}