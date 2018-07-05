package xyz.liweichao.auth.core.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.hicolors.colors.framework.model.error.ErrorResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.liweichao.auth.core.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ColorsOauthExceptionSerializer
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/29
 */

public class ColorsOauthExceptionSerializer extends StdSerializer<ColorsOauthException> {

    public ColorsOauthExceptionSerializer() {
        super(ColorsOauthException.class);
    }

    @Override
    public void serialize(ColorsOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ErrorResponse response = ResponseUtils.transfer(value, request);
        response.setCode(123456789L);
        gen.writeObject(response);
        gen.writeEndObject();
    }
}