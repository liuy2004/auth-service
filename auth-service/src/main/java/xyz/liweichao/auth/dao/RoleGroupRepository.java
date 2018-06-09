package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.RoleGroup;

@Repository
public interface RoleGroupRepository extends IRepository<RoleGroup, Long> {
}