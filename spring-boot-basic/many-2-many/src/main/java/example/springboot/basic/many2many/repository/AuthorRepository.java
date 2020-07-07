package example.springboot.basic.many2many.repository;

import example.springboot.basic.many2many.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
