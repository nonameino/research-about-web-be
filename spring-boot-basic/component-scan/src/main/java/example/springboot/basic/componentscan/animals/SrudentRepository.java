package example.springboot.basic.componentscan.animals;

import org.springframework.data.repository.CrudRepository;

public interface SrudentRepository extends CrudRepository<Student, Integer> {
}
