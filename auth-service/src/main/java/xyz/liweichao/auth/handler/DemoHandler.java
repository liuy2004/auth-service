package xyz.liweichao.auth.handler;

import com.github.hicolors.colors.framework.core.others.springmvc.error.hanlder.ErrorSourceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * DemoHandler
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/25
 */

@Service
public class DemoHandler implements ErrorSourceHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoHandler.class);

    @Override
    public boolean support(Object o) {
        return o.getClass().isAssignableFrom(Demo.class);
    }

    @Override
    public void dispose(Object o) {
        Demo demo = (Demo) o;
        LOGGER.info(demo.toString());
    }
}
