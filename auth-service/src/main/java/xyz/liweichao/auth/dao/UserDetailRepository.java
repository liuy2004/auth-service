package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.UserDetail;

@Repository
public interface UserDetailRepository extends IRepository<UserDetail, Long> {


    @Query("from UserDetail where mobile = :unique or email = :unique")
    UserDetail findByMobileOrEmail(@Param("unique") String unique);
}
