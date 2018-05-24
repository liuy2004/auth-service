package xyz.liweichao.auth.core.utils;

import com.github.hicolors.colors.framework.core.common.utils.JsonUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * note
 *
 * @author 李伟超
 * @date 2018/03/17
 */
public class ResponseUtils {

    public static void json(HttpServletResponse response, Object object) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(JsonUtils.serializeExcludes(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
