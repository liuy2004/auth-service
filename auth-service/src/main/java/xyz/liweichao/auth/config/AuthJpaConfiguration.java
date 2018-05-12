package xyz.liweichao.auth.config;

import com.github.hicolors.colors.framework.core.others.jpa.dao.ColorsComplexRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Jpa Configuration 配置
 *
 * @author 李伟超
 * @date 2018/01/09
 */
@Configuration
@EnableJpaRepositories(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        value = {JpaRepository.class}
                )
        },
        basePackages = "xyz.liweichao.**.dao",
        repositoryBaseClass = ColorsComplexRepository.class
)
public class AuthJpaConfiguration {
}