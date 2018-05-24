package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.common.abs.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IOrganizationApi;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.service.IOrganizationService;

@RestController
public class OrganizationController extends AbstractController<Organization, Long> implements IOrganizationApi {

    @Autowired
    private IOrganizationService service;

    public OrganizationController(IOrganizationService service) {
        super(service);
    }

}
