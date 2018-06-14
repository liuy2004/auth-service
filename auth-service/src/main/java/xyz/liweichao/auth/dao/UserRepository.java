package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.User;

import java.util.List;

@Repository
public interface UserRepository extends IRepository<User, Long> {

    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过 ids 查询用户列表
     *
     * @param ids
     * @return
     */
    List<User> findByIdIsIn(List<Long> ids);
}
