package example.springboot.basic.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Product product = new Product(null, "Hello", "Coding courses", null, new BigDecimal(0.789));
        Set<ConstraintViolation<Product>> constraintValidators = validator.validate(product);

        for(ConstraintViolation constraintViolation : constraintValidators) {
            String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
            System.out.println(fieldName +" " + constraintViolation.getMessage());
        }
    }
}
