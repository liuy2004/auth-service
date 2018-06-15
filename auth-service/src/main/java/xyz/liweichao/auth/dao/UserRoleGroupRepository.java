package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;

import java.util.List;

@Repository
public interface UserRoleGroupRepository extends IRepository<UserRoleGroup, Long> {

    List<UserRoleGroup> findByUserId(Long id);

    @Modifying
    @Query("delete from UserRoleGroup where user.id = ?1 and roleGroup.id = ?2")
    void deleteByUserIdAndRoleGroupId(Long id, Long gid);
}
