package xyz.liweichao.auth.core.custom;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * CustomOauthException
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/29
 */

@JsonSerialize(using = ColorsOauthExceptionSerializer.class)
public class ColorsOauthException extends OAuth2Exception {

    public ColorsOauthException(String msg) {
        super(msg);
    }

}