package xyz.liweichao.auth;

import com.github.hicolors.colors.framework.core.redisson.EnableRedisson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Auth Server Application
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/5/24
 */

@SpringBootApplication
@EnableRedisson
public class AuthServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
