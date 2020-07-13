package example.springboot.basic.restapihibernatevalodation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Component
public class ProductIdExistingValidator implements ConstraintValidator<ProductIdExisting,Long> {

    @Autowired
    private ProductService stock;

    @Override
    public boolean isValid(Long productId, ConstraintValidatorContext context) {
        return Objects.isNull(productId) || stock.findById(productId).isPresent();
    }
}
