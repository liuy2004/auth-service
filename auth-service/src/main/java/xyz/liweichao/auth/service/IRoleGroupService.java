package xyz.liweichao.auth.service;

import com.github.hicolors.colors.framework.core.abs.intf.IService;
import xyz.liweichao.auth.model.persistence.RoleGroup;

import java.util.ArrayList;

public interface IRoleGroupService extends IService<RoleGroup, Long> {

    RoleGroup users(Long id,ArrayList<Long> users);

}