package xyz.liweichao.auth.service;


import com.github.hicolors.colors.framework.core.abs.intf.IService;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;

public interface IUserDetailService extends IService<UserDetail, Long> {

    UserDetail queryByUniqueKey(String uniqueKey);

    UserDetail register(RegisterModel model);

    UserDetail modifyPasswordOnValid(String username, PasswordModel model);

    UserDetail resetPassword(UserDetail userDetail);
}