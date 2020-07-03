package example.springboot.basic.propertiesfiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties(prefix = "simple")
public class Entity {
    public static class A {
        private String b;

        public String getB() {
            log.info("getB");
            return b;
        }

        public void setB(String b) {
            log.info("setB");
            this.b = b;
        }
    }
    private A a;

    public A getA() {
        log.info("getA");
        return a;
    }

    public void setA(A a) {
        log.info("setA");
        this.a = a;
    }
}
