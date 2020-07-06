package example.springboot.basic.datarest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("example.springboot.basic.fake")
@Configuration
@Slf4j
public class Configurate {
    public Configurate() {
        log.info("Configurate");
    }
}
