package xyz.liweichao.auth.core.code;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import xyz.liweichao.auth.core.code.base.ValidateCodeType;
import xyz.liweichao.auth.core.properties.SecurityConstants;
import xyz.liweichao.auth.core.properties.SecurityProperties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 校验验证码的过滤器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateCodeFilter.class);

    /**
     * 验证码校验失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    /**
     * 系统配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 系统中的校验码处理器
     */
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;
    /**
     * 存放所有需要校验验证码的url
     */
    private Map<String, ValidateCodeType> urlMap = new HashMap<>();
    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 初始化要拦截的url配置信息
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
//        urlMap.put(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
//        addUrlToMap(securityProperties.getCode().getImage().getUrl(), ValidateCodeType.IMAGE);
        urlMap.put(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
        addUrlToMap(securityProperties.getCode().getSms().getUrl(), ValidateCodeType.SMS);
    }

    /**
     * 讲系统中配置的需要校验验证码的URL根据校验的类型放入map
     *
     * @param urlString
     * @param type
     */
    protected void addUrlToMap(String urlString, ValidateCodeType type) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (String url : urls) {
                urlMap.put(url, type);
            }
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        ValidateCodeType type = getValidateCodeType(request);
        if (type != null) {
            LOGGER.info("校验请求 [{}] 中的验证码,验证码类型 : [{}]", request.getRequestURI(), type);
            try {
                validateCodeProcessorHolder.findValidateCodeProcessor(type).validate(new ServletWebRequest(request, response));
            } catch (ValidateCodeException exception) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        chain.doFilter(request, response);

    }

    /**
     * 获取校验码的类型，如果当前请求不需要校验，则返回null
     *
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
        ValidateCodeType result = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), RequestMethod.GET.name())) {
            Set<String> urls = urlMap.keySet();
            for (String url : urls) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    result = urlMap.get(url);
                }
            }
        }
        return result;
    }

}
