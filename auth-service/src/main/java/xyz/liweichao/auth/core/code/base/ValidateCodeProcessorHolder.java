package xyz.liweichao.auth.core.code.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.liweichao.auth.core.code.exception.ValidateCodeException;
import xyz.liweichao.auth.core.code.exception.ValidateCodeExceptionEnum;

import java.util.Map;

/**
 * 校验码处理器管理器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    /**
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException(ValidateCodeExceptionEnum.PROCESSOR_NOT_FOUND, name);
        }
        return processor;
    }

}