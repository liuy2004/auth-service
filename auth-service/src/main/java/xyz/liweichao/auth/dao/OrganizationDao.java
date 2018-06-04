package xyz.liweichao.auth.dao;

import com.github.hicolors.colors.framework.core.common.abs.intf.IDao;
import org.springframework.stereotype.Repository;
import xyz.liweichao.auth.model.persistence.Organization;

/**
 * OrganizationDao
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/1/4
 */
@Repository
public interface OrganizationDao extends IDao<Organization, Long> {


}