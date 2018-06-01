package xyz.liweichao.auth.service.impl;

import com.github.hicolors.colors.framework.core.common.abs.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liweichao.auth.dao.OrganizationDao;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.service.IOrganizationService;

@Service
public class OrganizationServiceImpl extends AbstractService<Organization, Long> implements IOrganizationService {

    public OrganizationServiceImpl(OrganizationDao dao) {
        super(dao);
    }
}