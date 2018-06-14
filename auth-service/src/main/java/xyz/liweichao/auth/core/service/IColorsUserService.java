package xyz.liweichao.auth.core.service;

import xyz.liweichao.auth.core.model.ColorsUser;

/**
 * IColorsUserService
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */

public interface IColorsUserService {

    ColorsUser loadUserByUniqueKey(String uniqueKey);

}
