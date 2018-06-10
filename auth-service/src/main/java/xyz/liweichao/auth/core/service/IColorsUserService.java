package xyz.liweichao.auth.core.service;

import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;

import java.util.ArrayList;

/**
 * IColorsUserService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */

public interface IColorsUserService {

    ColorsUser loadUserByUniqueKey(String uniqueKey);

}
