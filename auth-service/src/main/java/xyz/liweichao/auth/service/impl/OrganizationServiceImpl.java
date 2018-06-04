package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import xyz.liweichao.auth.dao.OrganizationDao;
import xyz.liweichao.auth.exception.OrganizationException;
import xyz.liweichao.auth.exception.OrganizationExceptionEnum;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.service.IOrganizationService;

/**
 * OrganizationServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/1
 */
@Service
public class OrganizationServiceImpl extends AbstractService<Organization, Long> implements IOrganizationService {

    public OrganizationServiceImpl(OrganizationDao dao) {
        super(dao);
    }

    private Organization get(Long id) {
        return dao.getOne(id);
    }

    private Organization buildParam(Organization bean) {
        if (ObjectUtils.isEmpty(bean.getParent())) {
            throw new OrganizationException(OrganizationExceptionEnum.PARENT_ID_NOT_FOUND, bean.getParent().getId());
        }
        Organization parent = get(bean.getParent().getId());
        if (ObjectUtils.isEmpty(parent)) {
            throw new OrganizationException(OrganizationExceptionEnum.PARENT_ID_NOT_FOUND, bean.getParent().getId());
        }
        bean.setDisplayName(parent.getDisplayName() + bean.getName());
        bean.setLayer(parent.getLayer() + 1);
        bean.setPath(parent.getPath() + bean.getSeparator() + parent.getId());
        return bean;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Organization save(Organization bean) {
        return dao.save(buildParam(bean));
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Organization update(Organization bean) {
        return dao.save(buildParam(bean));
    }
}