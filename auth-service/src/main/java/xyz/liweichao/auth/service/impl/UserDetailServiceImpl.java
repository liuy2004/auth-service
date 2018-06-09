package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.common.utils.ReflectionUtils;
import com.github.hicolors.colors.framework.common.utils.StringUtils;
import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.liweichao.auth.dao.UserDetailRepository;
import xyz.liweichao.auth.dao.UserRepository;
import xyz.liweichao.auth.exception.UserDetailException;
import xyz.liweichao.auth.exception.UserDetailExceptionEnum;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;
import xyz.liweichao.auth.service.IUserDetailService;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.Objects;


/**
 * UserDetailServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class UserDetailServiceImpl extends AbstractService<UserDetail, Long> implements IUserDetailService {

    private final UserDetailRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static Date DEFAULT_EXPIRED = ReflectionUtils.convert("9999-12-31 23:59:59", Date.class);

    private static Date DEFAULT_BIRTHDAY = ReflectionUtils.convert("2000-01-01", Date.class);

    private static Long DEFAULT_ORGANIZATION_ID = 1L;

    private static String DEFAULT_STRING = "";

    private static String DEFAULT_PASSWORD = "000000";


    public UserDetailServiceImpl(UserDetailRepository repository) {
        super(repository);
        this.repository = repository;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetail register(RegisterModel model) {
        //todo 验证码校验

        //进行重复校验
        if (Objects.nonNull(queryByUniqueKey(model.getUnique()))) {
            throw new UserDetailException(UserDetailExceptionEnum.UNIQUE_CONFLICT, model.getUnique());
        }
        User user = new User();
        user.setUsername(StringUtils.uuid());
        user.setPassword(passwordEncoder.encode(model.getCode()));
        user.setNickName(StringUtils.format("火星人{}号", RandomUtils.nextInt()));
        user.setCredentialsExpiredDate(DEFAULT_EXPIRED);
        user.setExpiredDate(DEFAULT_EXPIRED);
        user.setEnabled(Boolean.TRUE);
        user.setLockStatus(Boolean.FALSE);
        userRepository.save(user);
        UserDetail userDetail = new UserDetail();
        userDetail.setId(user.getId());
        userDetail.setBirthday(DEFAULT_BIRTHDAY);
        userDetail.setMobile(model.getUnique());
        userDetail.setEmail(user.getUsername());
        userDetail.setName(user.getNickName());
        userDetail.setOrganization(new Organization(DEFAULT_ORGANIZATION_ID));
        userDetail.setFavicon(DEFAULT_STRING);
        userDetail.setWebsite(DEFAULT_STRING);
        userDetail.setDescription(DEFAULT_STRING);
        return repository.save(userDetail);
    }

    @Override
    public UserDetail modifyPasswordOnValid(String username, PasswordModel model) {
        UserDetail userDetail = queryByUniqueKey(username);
        if(passwordEncoder.matches(model.getOldPassword(),userDetail.getUser().getPassword())){
            User user = userRepository.findOne(userDetail.getId());
            user.setPassword(model.getPassword());
            userRepository.saveAndFlush(user);
        }else{
            throw new UserDetailException(UserDetailExceptionEnum.PASSWORD_INCORRECT);
        }
        return userDetail;
    }

    @Override
    public UserDetail resetPassword(UserDetail userDetail) {
        User user = userRepository.findOne(userDetail.getId());
        user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        userRepository.saveAndFlush(user);
        return userDetail;
    }
}
