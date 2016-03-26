package be.piyush.core.config;

// @formatter:off

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 26/3/16, 11:26 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "be.piyush.core.repository")
@ComponentScan(basePackages = "be.piyush.core")
@PropertySource(value = { "classpath:persistence-${spring.profiles.active:dev}.properties" })
public class PersistenceConfig {

    @Autowired
    Environment environment;

    @Bean
    public JpaTransactionManager transactionManager() {
        EntityManagerFactory emf = entityManagerFactory().getObject();
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        log.debug("Initializing EntityManagerFactory.");
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(environment.getProperty("packages.to.scan"));
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaProperties(hibernateProperties());
        emf.setPersistenceUnitName(environment.getProperty("PU_NAME", "WEB_APP"));
        log.debug("Finished initialization for EntityManagerFactory.");
        return emf;
    }

    @Bean
    public DataSource dataSource(){
        log.debug("Initializing datasource");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setMaximumPoolSize(environment.getProperty("jdbc.maxActive", Integer.class));
        dataSource.setMinimumIdle(environment.getProperty("jdbc.minIdle", Integer.class));
        dataSource.setConnectionTestQuery(environment.getProperty("jdbc.validationQuery"));

        dataSource.addDataSourceProperty("useServerPrepStmts", true);
        dataSource.addDataSourceProperty("initializationFailFast", true);
        dataSource.setIdleTimeout(6000L);
        dataSource.setMaxLifetime(60000L);
        log.debug("Finished initialization for Datasource.");
        return dataSource;
    }

    @Bean(name = "hibernateProperties")
    public Properties hibernateProperties() {
        return new Properties() {
            private static final long serialVersionUID = 1779427567126967954L;

            {
                put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
                put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
                put("hibernate.use_sql_comments", environment.getProperty("hibernate.use_sql_comments"));
                put("hibernate.connection.autocommit", environment.getProperty("hibernate.connection.autocommit"));
                put("hibernate.connection.release_mode", environment.getProperty("hibernate.connection.release_mode"));
                put("current_session_context_class", environment.getProperty("current_session_context_class"));
                put("hibernate.connection.isolation", environment.getProperty("hibernate.connection.isolation"));
                put("hibernate.generate_statistics", "true");
                put("hibernate.enable_lazy_load_no_trans",
                        environment.getProperty("hibernate.enable_lazy_load_no_trans"));
            }
        };
    }
}
