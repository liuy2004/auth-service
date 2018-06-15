package xyz.liweichao.auth.core.code.base;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public interface ValidateCodeGenerator {

    /**
     * 生成校验码
     *
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);

}