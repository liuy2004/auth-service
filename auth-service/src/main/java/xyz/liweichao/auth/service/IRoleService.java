package xyz.liweichao.auth.service;

import com.github.hicolors.colors.framework.core.abs.Service;
import xyz.liweichao.auth.model.persistence.Role;

import java.util.ArrayList;

public interface IRoleService extends Service<Role, Long> {
    Role users(Role role, ArrayList<Long> users);
}