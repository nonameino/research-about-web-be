package example.springboot.basic.componentscan;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"example.springboot.basic.fake", "example.springboot.basic.componentscan.*"})
@EntityScan(basePackages = {"example.springboot.basic.fake", "example.springboot.basic.componentscan.*"})
public class ExampleConfiguration {}
