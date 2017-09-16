package daggerok.config;

import daggerok.AppApplication;
import daggerok.props.AppProps;
import daggerok.props.DbProps;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackageClasses = {
    AppApplication.class,
    AppProps.class,
    DbProps.class,
})
public class AppConfig {}
