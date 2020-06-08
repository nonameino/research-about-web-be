package example.springdata.jpa.interceptors;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
