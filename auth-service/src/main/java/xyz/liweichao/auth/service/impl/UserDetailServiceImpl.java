package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.UserDetailRepository;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.service.IUserDetailService;

import javax.persistence.criteria.Predicate;


/**
 * UserDetailServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class UserDetailServiceImpl extends AbstractService<UserDetail, Long> implements IUserDetailService {

    public UserDetailServiceImpl(UserDetailRepository repository) {
        super(repository);
    }

    @Override
    public UserDetail queryByUniqueKey(String uniqueKey) {
        return repository.findOne((root, query, cb) -> {
            Predicate mobile = cb.equal(root.get("mobile").as(String.class), uniqueKey);
            Predicate email = cb.equal(root.get("email").as(String.class), uniqueKey);
            query.where(cb.or(mobile, email));
            return query.getRestriction();
        });
    }
}
