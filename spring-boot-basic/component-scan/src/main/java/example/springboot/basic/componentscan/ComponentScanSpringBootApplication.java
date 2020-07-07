package example.springboot.basic.componentscan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class ComponentScanSpringBootApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ComponentScanSpringBootApplication.class, args);

        for(String beanName : applicationContext.getBeanDefinitionNames()) {
            log.info(beanName);
        }
    }
}
