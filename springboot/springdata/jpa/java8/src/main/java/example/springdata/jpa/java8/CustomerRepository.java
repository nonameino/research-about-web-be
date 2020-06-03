package example.springdata.jpa.java8;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(Long id);
    <S extends Customer> S save (S customer);
    Optional<Customer> findByLastname(String lastname);
    default Optional<Customer> findByLastname(Customer customer) {
        return findByLastname(customer == null ? null : customer.getLastname());
    }
    @Query("select c from Customer c")
    Stream<Customer> streamAllCustomers();
    Stream<Customer> findAllByLastnameIsNotNull();
    @Async
    CompletableFuture<List<Customer>> readAllBy();
}
