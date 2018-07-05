package xyz.liweichao.auth.service;


import com.github.hicolors.colors.framework.core.abs.Service;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;

public interface IUserDetailService extends Service<UserDetail, Long> {

    UserDetail queryByUniqueKey(String uniqueKey);

    UserDetail register(RegisterModel model);

    UserDetail modifyPasswordOnValid(PasswordModel model);

    UserDetail resetPassword(UserDetail userDetail);

}