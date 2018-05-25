package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.common.abs.intf.IDao;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;

@Repository
public interface UserRoleGroupDao extends IDao<UserRoleGroup, Long> {
}
