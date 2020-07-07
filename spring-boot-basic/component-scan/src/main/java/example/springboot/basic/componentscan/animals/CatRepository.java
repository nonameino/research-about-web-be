package example.springboot.basic.componentscan.animals;

import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Integer> {
}
