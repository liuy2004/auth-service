package xyz.liweichao.auth.model.persistence.databinds;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import xyz.liweichao.auth.model.persistence.Organization;

import java.io.IOException;

/**
 * Organization Serializer
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
public class OrganizationSerializer extends JsonSerializer<Organization> {

    @Override
    public void serialize(Organization org, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(String.valueOf(org.getId()));
    }

}