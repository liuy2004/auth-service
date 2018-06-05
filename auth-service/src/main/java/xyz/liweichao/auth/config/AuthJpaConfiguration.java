package xyz.liweichao.auth.config;

import com.github.hicolors.colors.framework.core.others.jpa.dao.ColorsComplexRepository;
import org.hibernate.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Interceptor myInterceptor;

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            EntityManagerFactoryBuilder factory, DataSource dataSource,
//            JpaProperties properties) {
//        Map<String, Object> jpaProperties = new HashMap<String, Object>();
//        jpaProperties.putAll(properties.getHibernateProperties(dataSource));
//        jpaProperties.put("hibernate.ejb.interceptor", myInterceptor);
//        return factory.dataSource(dataSource).packages("xyz.liweichao.auth.dao")
//                .properties((Map) jpaProperties).build();
//    }

}