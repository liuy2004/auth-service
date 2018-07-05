package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.liweichao.auth.model.persistence.UserDetail;

@org.springframework.stereotype.Repository
public interface UserDetailRepository extends Repository<UserDetail, Long> {


    @Query("from UserDetail where mobile = :unique or email = :unique")
    UserDetail findByMobileOrEmail(@Param("unique") String unique);
}
