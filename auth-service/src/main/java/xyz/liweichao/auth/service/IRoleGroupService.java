package xyz.liweichao.auth.service;

import com.github.hicolors.colors.framework.core.abs.Service;
import xyz.liweichao.auth.model.persistence.RoleGroup;

import java.util.ArrayList;

public interface IRoleGroupService extends Service<RoleGroup, Long> {

    RoleGroup users(RoleGroup roleGroup, ArrayList<Long> users);

}