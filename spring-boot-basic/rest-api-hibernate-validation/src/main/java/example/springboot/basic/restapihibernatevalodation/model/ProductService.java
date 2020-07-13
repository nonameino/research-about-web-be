package example.springboot.basic.restapihibernatevalodation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository stock;

    @Autowired
    public ProductService(ProductRepository stock) {
        this.stock = stock;
    }

    public List<Product> findAll() {
        return stock.findAll();
    }

    public Optional<Product> findById(Long id) {
        return stock.findById(id);
    }

    public Product save(Product product) {
        return stock.save(product);
    }

    public void deleteById(Long id) {
        stock.deleteById(id);
    }
}
