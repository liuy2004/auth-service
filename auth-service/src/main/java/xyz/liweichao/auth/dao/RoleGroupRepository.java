package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.Repository;
import xyz.liweichao.auth.model.persistence.RoleGroup;

import java.util.List;

@org.springframework.stereotype.Repository
public interface RoleGroupRepository extends Repository<RoleGroup, Long> {

    List<RoleGroup> findByIdIsIn(List<Long> ids);
}