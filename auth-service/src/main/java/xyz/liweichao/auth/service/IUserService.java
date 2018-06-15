package xyz.liweichao.auth.service;

import com.github.hicolors.colors.framework.core.abs.intf.IService;
import xyz.liweichao.auth.model.persistence.User;

import java.util.ArrayList;

public interface IUserService extends IService<User, Long> {

    User queryUserByUniqueKey(String uniqueKey);

    User loadUserAuthInfo(String uniqueKey);

    User roles(User user, ArrayList<Long> roles);

    User groups(User user, ArrayList<Long> groups);

    void deleteRoleGroup(User user, Long gid);

    void deleteRole(User user, Long rid);

}