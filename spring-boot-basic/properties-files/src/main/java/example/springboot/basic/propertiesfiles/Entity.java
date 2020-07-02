package example.springboot.basic.propertiesfiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "simple")
public class Entity {
    public static class A {
        private String b;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            b = b;
        }
    }
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        a = a;
    }
}
