package example.springdata.jdbc.basics.simpleentity;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>, WithInsert<Category> {
}
