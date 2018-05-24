package xyz.liweichao.auth;

import com.github.hicolors.colors.framework.core.others.redisson.EnableRedisson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedisson
public class AuthServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
