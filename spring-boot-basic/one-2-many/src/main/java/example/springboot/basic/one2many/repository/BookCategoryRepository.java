package example.springboot.basic.one2many.repository;

import example.springboot.basic.one2many.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
