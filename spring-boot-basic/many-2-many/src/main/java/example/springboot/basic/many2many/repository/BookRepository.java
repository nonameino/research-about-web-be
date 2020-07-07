package example.springboot.basic.many2many.repository;

import example.springboot.basic.many2many.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
