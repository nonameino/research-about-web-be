package example.springboot.basic.restapihibernatevalodation.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    @NotNull(message = "{NotNull.name}")
    private String name;

    @Size(max = 10)
    private String description;

    @Min(1)
    private BigDecimal price;
}
