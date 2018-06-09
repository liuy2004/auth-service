package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import com.github.hicolors.colors.framework.core.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.core.exception.UserNotFoundException;
import xyz.liweichao.auth.core.model.ColorsUser;
import xyz.liweichao.auth.core.service.IColorsUserService;
import xyz.liweichao.auth.dao.UserRepository;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;
import xyz.liweichao.auth.service.IUserService;

import javax.persistence.criteria.Predicate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * UserServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */
@Service
public class UserServiceImpl extends AbstractService<User, Long> implements IUserService, IColorsUserService {

    private UserRepository repository;

    @Autowired
    private IUserDetailService userDetailService;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public User queryUserByUniqueKey(String uniqueKey) {
        return repository.findOne((root, query, cb) -> {
            Predicate username = cb.equal(root.get("username").as(String.class), uniqueKey);
            query.where(username);
            return query.getRestriction();
        });
    }

    @Override
    public User loadUserAuthInfo(String uniqueKey) {
        User user = queryUserByUniqueKey(uniqueKey);
        if (Objects.nonNull(user)) {
            if (Objects.isNull(userDetailService.queryOne(user.getId()))) {
                throw new UserNotFoundException("当前账户的详细信息不存在！");
            }
        } else {
            UserDetail userDetail = userDetailService.queryByUniqueKey(uniqueKey);
            if (Objects.nonNull(userDetail)) {
                user = queryOne(userDetail.getId());
                if (Objects.isNull(user)) {
                    throw new UserNotFoundException("当前账户的认证信息不存在！");
                }
            } else {
                throw new UserNotFoundException("当前账户的信息不存在！");
            }
        }
        return user;
    }

    @Override
    public ColorsUser loadUserByUniqueKey(String uniqueKey) {
        ColorsUser colorsUser = new ColorsUser();
        User user = loadUserAuthInfo(uniqueKey);
        UserDetail userDetail = userDetailService.queryOne(user.getId());
        BeanUtils.copyProperties(user, colorsUser);
        BeanUtils.copyProperties(userDetail, colorsUser);
        colorsUser.setRoles(findAllRoles(user.getId()));
        return colorsUser;
    }

    private Set<String> findAllRoles(Long userId) {
        Set<String> roles = new HashSet<>();
        roles.add(String.valueOf(userId));
        return roles;
    }

}
