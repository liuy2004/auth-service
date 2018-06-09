package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.abs.AbstractController;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IOrganizationApi;
import xyz.liweichao.auth.model.persistence.Organization;
import xyz.liweichao.auth.service.IOrganizationService;

/**
 * OrganizationController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class OrganizationController extends AbstractController<Organization, Long> implements IOrganizationApi {

    public OrganizationController(IOrganizationService service) {
        super(service);
    }

}
