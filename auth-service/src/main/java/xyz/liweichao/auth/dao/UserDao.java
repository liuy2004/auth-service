package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.common.abs.intf.AbstractDao;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.User;

@Repository
public interface UserDao extends AbstractDao<User, Long> {
}
