package example.springboot.basic.many2many.repository;

import example.springboot.basic.many2many.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher,Integer> {
}
