package be.piyush.config;

// @formatter:off

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 26/3/16, 9:43 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO to current update version
 */
// @formatter:on

@Configuration
@ComponentScan(basePackages = "be.piyush")
@PropertySource(value = "classpath:application.properties")
public class AppConfig {
}
