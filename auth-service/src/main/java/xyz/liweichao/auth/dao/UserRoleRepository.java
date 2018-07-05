package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import xyz.liweichao.auth.model.persistence.UserRole;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRoleRepository extends Repository<UserRole, Long> {

    List<UserRole> findByUserId(Long id);


    @Modifying
    @Query("delete from UserRole where user.id = ?1 and role.id = ?2")
    void deleteByIdUserId(Long id, Long rid);
}
