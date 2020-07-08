package example.springboot.basic.one2many.repository;

import example.springboot.basic.one2many.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page,Integer> {
}
