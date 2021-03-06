package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.abs.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import xyz.liweichao.auth.dao.OrganizationRepository;
import xyz.liweichao.auth.dao.UserDetailRepository;
import xyz.liweichao.auth.exception.OrganizationException;
import xyz.liweichao.auth.exception.OrganizationExceptionEnum;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.service.IOrganizationService;

import java.util.Objects;

/**
 * OrganizationServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class OrganizationServiceImpl extends AbstractService<Organization, Long> implements IOrganizationService {

    protected final String separator = ";";

    private OrganizationRepository repository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    public OrganizationServiceImpl(OrganizationRepository repository) {
        super(repository);
        this.repository = repository;

    }

    private Organization buildParam(Organization bean) {
        if (ObjectUtils.isEmpty(bean.getParent())) {
            throw new OrganizationException(OrganizationExceptionEnum.PARENT_ID_NOT_FOUND);
        }
        Organization parent = queryOne(bean.getParent().getId());
        if (ObjectUtils.isEmpty(parent)) {
            throw new OrganizationException(OrganizationExceptionEnum.PARENT_ID_NOT_FOUND, bean.getParent().getId());
        }
        bean.setDisplayName(parent.getDisplayName() + bean.getName());
        bean.setLayer(parent.getLayer() + 1);
        bean.setPath(parent.getPath() + separator + parent.getId());
        return bean;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Organization save(Organization bean) {
        if (Objects.nonNull(repository.findByCode(bean.getCode()))) {
            throw new OrganizationException(OrganizationExceptionEnum.CODE_EXISTING, bean.getCode());
        }
        return repository.save(buildParam(bean));
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Organization update(Organization bean) {
        if (bean.getLayer().equals(0)) {
            throw new OrganizationException(OrganizationExceptionEnum.ROOT_MODIFY_REFUSED);
        }
        if (StringUtils.isNotBlank(bean.getCode())) {
            Organization old = repository.findByCode(bean.getCode());
            if (Objects.nonNull(old) && !old.getId().equals(bean.getId())) {
                throw new OrganizationException(OrganizationExceptionEnum.CODE_EXISTING, bean.getCode());
            }
        }
        return repository.save(buildParam(bean));
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Long id) {
        Organization bean = queryOne(id);
        if (Objects.isNull(bean)) {
            return;
        }
        String parent = "parent";
        String organization = "organization";
        String primaryKey = "id";
        if (repository.count((root, query, cb) -> query.where(cb.equal(root.get(parent).get(primaryKey), bean.getId())).getRestriction()) < 0) {
            if (userDetailRepository.count((root, query, cb) -> query.where(cb.equal(root.get(organization).get(primaryKey), bean.getId())).getRestriction()) < 0) {
                this.repository.delete(bean);
            } else {
                throw new OrganizationException(OrganizationExceptionEnum.HAS_USER);
            }
        } else {
            throw new OrganizationException(OrganizationExceptionEnum.HAS_CHILDREN);
        }
    }
}