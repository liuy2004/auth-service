package xyz.liweichao.auth.dao;


import com.github.hicolors.colors.framework.core.abs.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import xyz.liweichao.auth.model.persistence.UserRoleGroup;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRoleGroupRepository extends Repository<UserRoleGroup, Long> {

    List<UserRoleGroup> findByUserId(Long id);

    @Modifying
    @Query("delete from UserRoleGroup where user.id = ?1 and roleGroup.id = ?2")
    int deleteByUserIdAndRoleGroupId(Long id, Long gid);
}
