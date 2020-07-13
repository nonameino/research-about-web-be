package example.springboot.basic.restapihibernatevalodation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ProductIdExisting
    private Long id;

    @NotNull(message = "{NotNull.name}")
    private String name;

    @Size(max = 10)
    private String description;

    @Min(1)
    private BigDecimal price;
}
