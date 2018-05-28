package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.core.exception.AcountNotFoundException;
import xyz.liweichao.auth.dao.UserDao;
import xyz.liweichao.auth.dao.UserDetailDao;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;
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

    @Autowired
    private UserDao dao;

    @Autowired
    private UserDetailDao userDetailDao;

    public UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public User queryByUniqueKey(String uniqueKey) {
        User user = dao.findOne((root, query, cb) -> {
            Predicate username = cb.equal(root.get("username").as(String.class), uniqueKey);
            query.where(username);
            return query.getRestriction();
        });
        if (Objects.nonNull(user)) {
            return user;
        } else {
            UserDetail userDetail = userDetailDao.findOne((root, query, cb) -> {
                Predicate mobile = cb.equal(root.get("mobile").as(String.class), uniqueKey);
                Predicate email = cb.equal(root.get("email").as(String.class), uniqueKey);
                query.where(cb.or(mobile, email));
                return query.getRestriction();
            });

            if (Objects.nonNull(userDetail)) {
                user = dao.getOne(userDetail.getId());
            }
            if (Objects.nonNull(user)) {
                return user;
            } else {
                throw new AcountNotFoundException("当前用户不存在！");
            }
        }
    }
}
