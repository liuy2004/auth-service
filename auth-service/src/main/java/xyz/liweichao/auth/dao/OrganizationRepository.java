package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.abs.intf.IRepository;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.Organization;

/**
 * OrganizationDao
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/1/4
 */
@Repository
public interface OrganizationRepository extends IRepository<Organization, Long> {

    /**
     * 通过组织机构代码查询
     *
     * @param code
     * @return
     */
    Organization findByCode(String code);

}