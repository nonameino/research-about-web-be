package example.springdata.jpa.security;

import org.springframework.data.repository.CrudRepository;

public interface BusinessObjectRepository extends CrudRepository<BusinessObject,Long> {
}
