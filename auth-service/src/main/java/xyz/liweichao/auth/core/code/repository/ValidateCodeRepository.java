package xyz.liweichao.auth.core.code.repository;


import xyz.liweichao.auth.core.code.base.ValidateCode;
import xyz.liweichao.auth.core.code.base.ValidateCodeType;

/**
 * 校验码存取器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
public interface ValidateCodeRepository {

    /**
     * 保存验证码
     *
     * @param key
     * @param code
     * @param validateCodeType
     */
    void save(String key, ValidateCode code, ValidateCodeType validateCodeType);

    /**
     * 获取验证码
     *
     * @param key
     * @param validateCodeType
     * @return
     */
    ValidateCode get(String key, ValidateCodeType validateCodeType);

    /**
     * 移除验证码
     *
     * @param key
     * @param codeType
     */
    void remove(String key, ValidateCodeType codeType);

    /**
     * 判断是否含有当前验证码
     *
     * @param key
     * @param codeType
     * @return
     */
    boolean hasKey(String key, ValidateCodeType codeType);

    /**
     * 获取过期时间
     *
     * @param key
     * @param codeType
     * @return
     */
    Long getExpire(String key, ValidateCodeType codeType);
}
