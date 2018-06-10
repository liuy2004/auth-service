package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.User;

@Repository
public interface UserRepository extends IRepository<User, Long> {

    User findByUsername(String username);
}
