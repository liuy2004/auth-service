package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.core.exception.UserNotFoundException;
import xyz.liweichao.auth.dao.UserRepository;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;
import xyz.liweichao.auth.service.IUserService;

import javax.persistence.criteria.Predicate;
import java.util.Objects;

/**
 * UserServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/28
 */
@Service
public class UserServiceImpl extends AbstractService<User, Long> implements IUserService {

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
}
