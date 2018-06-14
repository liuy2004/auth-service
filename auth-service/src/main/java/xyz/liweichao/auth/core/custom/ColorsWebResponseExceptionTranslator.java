package xyz.liweichao.auth.core.custom;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;


/**
 * CustomWebResponseExceptionTranslator
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/29
 */

@Component("colorsWebResponseExceptionTranslator")
public class ColorsWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) {
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new ColorsOauthException(oAuth2Exception.getMessage()));
    }
}