package xyz.liweichao.auth.service;

import com.github.hicolors.colors.framework.core.common.abs.intf.IService;
import xyz.liweichao.auth.model.persistence.User;

public interface IUserService extends IService<User, Long> {

    User queryByUniqueKey(String uniqueKey);
}