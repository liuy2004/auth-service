package xyz.liweichao.auth.model.persistence.databinds;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.ObjectUtils;
import xyz.liweichao.auth.model.persistence.Organization;

import java.io.IOException;

/**
 * Organization Deserializer
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
public class OrganizationDeserializer extends JsonDeserializer<Organization> {

    @Override
    public Organization deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Long value = jp.getValueAsLong();
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        return new Organization(value);
    }
}