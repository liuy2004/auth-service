package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends IRepository<UserRole, Long> {

    @Query("from UserRole where user.id = :id")
    List<UserRole> findAllByUserId(@Param("id") Long id);
}
