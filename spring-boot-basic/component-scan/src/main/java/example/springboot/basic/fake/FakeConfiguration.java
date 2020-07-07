package example.springboot.basic.fake;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeConfiguration {
    @Bean
    public String getFake() {
        return "Hello!...";
    }
}
