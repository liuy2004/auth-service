package xyz.liweichao.auth.core.token;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import xyz.liweichao.auth.core.model.ColorsUser;

import java.util.Map;

/**
 * TokenEnhancer
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public class JwtTokenEnhancer implements TokenEnhancer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenEnhancer.class);

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = Maps.newHashMap();
        ColorsUser currentUser = (ColorsUser) authentication.getPrincipal();
        info.put("info", currentUser.buildSimpleColorsUser());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}