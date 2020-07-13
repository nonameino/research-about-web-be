package example.springboot.basic.restapihibernatevalodation.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ProductIdExistingValidator.class)
public @interface ProductIdExisting {
    String message() default "{ProductIDExisting}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
