package xyz.liweichao.auth.core.utils;

import com.github.hicolors.colors.framework.common.exception.RestfulException;
import com.github.hicolors.colors.framework.core.common.utils.JsonUtils;
import com.github.hicolors.colors.framework.core.common.utils.SpringContextUtils;
import com.github.hicolors.colors.framework.core.others.springmvc.error.ErrorEvent;
import com.github.hicolors.colors.framework.core.others.springmvc.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * note
 *
 * @author 李伟超
 * @date 2018/03/17
 */
public class ResponseUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtils.class);

    public static void json(HttpServletResponse response, Object object) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(JsonUtils.serializeExcludes(object));
        } catch (IOException e) {
            LOGGER.error("ResponseUtils {}", e.getMessage());
        }
    }

    public static void json(HttpServletRequest request, HttpServletResponse response, RestfulException restful) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(JsonUtils.serializeExcludes(errorAttributes(restful, request, response)));
        } catch (IOException e) {
            LOGGER.error("ResponseUtils {}", e.getMessage());
        }
    }

    public static ErrorResponse errorAttributes(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        ErrorResponse error = new ErrorResponse(request);
        //特定异常处理所需要的参数
        Object data = new Object();
        if (exception instanceof RestfulException) {
            RestfulException restful = (RestfulException) exception;
            error.setStatus(restful.getStatusCode().value()).setCode(restful.getCode()).setMessage(restful.getMessage());
            data = restful.getData();
            response.setStatus(restful.getStatusCode().value());
        } else {
            LOGGER.error(exception.getMessage(), exception);
            error.setCode(1000000L);
            error.setMessage(exception.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        SpringContextUtils.publish(new ErrorEvent(error, data));
        return error;

    }
}
