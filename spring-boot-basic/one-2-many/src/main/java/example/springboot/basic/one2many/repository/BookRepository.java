package example.springboot.basic.one2many.repository;

import example.springboot.basic.one2many.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
