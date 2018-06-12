package xyz.liweichao.auth.service;

import com.github.hicolors.colors.framework.core.abs.intf.IService;
import xyz.liweichao.auth.model.persistence.Role;

import java.util.ArrayList;

public interface IRoleService extends IService<Role, Long> {
      Role users(Long id,ArrayList<Long> users);
}