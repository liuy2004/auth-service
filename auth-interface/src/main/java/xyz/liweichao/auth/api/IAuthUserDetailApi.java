package xyz.liweichao.auth.api;

import com.github.hicolors.colors.framework.core.common.abs.IController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.model.persistence.AuthUserDetail;

/**
 * note
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/5/12
 */
@Api(tags = "auth-user-detail", description = "对用户详细信息操作接口")
@RequestMapping("auth-user-detail")
public interface IAuthUserDetailApi extends IController<AuthUserDetail, Long> {
}