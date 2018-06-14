package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.common.utils.ReflectionUtils;
import com.github.hicolors.colors.framework.common.utils.StringUtils;
import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.liweichao.auth.dao.RoleRepository;
import xyz.liweichao.auth.dao.UserDetailRepository;
import xyz.liweichao.auth.dao.UserRepository;
import xyz.liweichao.auth.dao.UserRoleRepository;
import xyz.liweichao.auth.exception.UserDetailException;
import xyz.liweichao.auth.exception.UserDetailExceptionEnum;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.model.persistence.UserDetail;
import xyz.liweichao.auth.model.request.PasswordModel;
import xyz.liweichao.auth.model.request.RegisterModel;
import xyz.liweichao.auth.service.IUserDetailService;
import xyz.liweichao.auth.service.IUserService;

import java.util.Date;


/**
 * UserDetailServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class UserDetailServiceImpl extends AbstractService<UserDetail, Long> implements IUserDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);
    private static Date DEFAULT_EXPIRED = ReflectionUtils.convert("9999-12-31 23:59:59", Date.class);
    private static Date DEFAULT_BIRTHDAY = ReflectionUtils.convert("2000-01-01", Date.class);
    private static Long DEFAULT_ORGANIZATION_ID = 1L;
    private static String DEFAULT_STRING = "";
    private static String DEFAULT_PASSWORD = "000000";
    private final UserDetailRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserService userService;


    public UserDetailServiceImpl(UserDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserDetail queryByUniqueKey(String uniqueKey) {
        return repository.findByMobileOrEmail(uniqueKey);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetail register(RegisterModel model) {
        //todo 验证码校验

        //进行重复校验
        if (org.apache.commons.lang3.ObjectUtils.anyNotNull(userService.queryUserByUniqueKey(model.getUnique()), queryByUniqueKey(model.getUnique()))) {
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
    @Transactional(rollbackFor = Exception.class)
    public UserDetail modifyPasswordOnValid(PasswordModel model) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.loadUserAuthInfo(username);
        if (passwordEncoder.matches(model.getOldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(model.getPassword()));
            userRepository.saveAndFlush(user);
        } else {
            throw new UserDetailException(UserDetailExceptionEnum.PASSWORD_INCORRECT);
        }
        return repository.getOne(user.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetail resetPassword(UserDetail userDetail) {
        User user = userRepository.findOne(userDetail.getId());
        user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        userRepository.saveAndFlush(user);
        return userDetail;
    }

}