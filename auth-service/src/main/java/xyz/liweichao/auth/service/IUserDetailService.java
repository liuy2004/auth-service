package xyz.liweichao.auth.service;


import com.github.hicolors.colors.framework.core.abs.intf.IService;
import xyz.liweichao.auth.model.persistence.UserDetail;

public interface IUserDetailService extends IService<UserDetail, Long> {

    UserDetail queryByUniqueKey(String uniqueKey);
}