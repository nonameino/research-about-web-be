package example.springboot.basic.many2many.repository;

import example.springboot.basic.many2many.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
