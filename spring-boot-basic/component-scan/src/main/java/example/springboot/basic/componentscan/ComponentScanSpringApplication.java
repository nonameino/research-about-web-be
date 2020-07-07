//package example.springboot.basic.componentscan;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
////@ComponentScan({"example.springboot.basic.animals", "example.springboot.basic.componentscan.flowers"})
//@Slf4j
//public class ComponentScanSpringApplication {
//    private static ApplicationContext applicationContext;
//
////    @Bean
////    public ExampleBean exampleBean() {
////
////    }
//
//    public static void main(String[] args) {
////        SpringApplication.run(Application.class, args);
//        applicationContext = new AnnotationConfigApplicationContext(ComponentScanSpringApplication.class);
//
//        for(String beanName : applicationContext.getBeanDefinitionNames()) {
//            log.info(beanName);
//        }
//    }
//}
