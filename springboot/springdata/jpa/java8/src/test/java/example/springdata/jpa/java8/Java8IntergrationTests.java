package example.springdata.jpa.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class Java8IntergrationTests {
    @Autowired
    private CustomerRepository repository;

    @Test
    public void providesFindOneWithOptional() {
        Customer carter = repository.save(new Customer("Carter", "Beauford"));

        assertThat(repository.findById(carter.getId())).isPresent();
        assertThat(repository.findById(carter.getId() + 1)).isEmpty();
    }

    @Test
    public void auditingSetsJdk8DateTimeTypes() {
        Customer customer = repository.save(new Customer("Dave", "Matthews"));

        assertThat(customer.getCreateDate()).isNotNull();
        assertThat(customer.getModifiedDate()).isNotNull();
    }

    @Test
    public void invokesDefaultMethod() {
        Customer customer = repository.save(new Customer("Dave", "Matthews"));
        Optional<Customer> result = repository.findByLastname(customer);

        assertThat(result).hasValue(customer);
    }

    @Test
    public void useJava8StreamsWithCustomQuery() {
        Customer customer = repository.save(new Customer("Customer1", "Foo"));
        Customer customer1 = repository.save(new Customer("Customer2", "Bar"));

        try (Stream<Customer> stream = repository.streamAllCustomers()) {
            assertThat(stream.collect(Collectors.toList())).contains(customer, customer1);
        }
    }

    @Test
    public void useJava8StreamWithDeriveQuery() {
        Customer customer = repository.save(new Customer("Customer1", "Foo"));
        Customer customer1 = repository.save(new Customer("Customer2", "Bar"));

        try (Stream<Customer> stream = repository.findAllByLastnameIsNotNull()) {
            assertThat(stream.collect(Collectors.toList())).contains(customer, customer1);
        }
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void rejectsStreamExecutionIfNotSurroundingTransactionActive() {
        repository.findAllByLastnameIsNotNull();
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void supportsCompletableFuturesAsReturnTypeWrapper() throws Exception{
        repository.save(new Customer("Customer1", "Foo"));
        repository.save(new Customer("Customer2", "Bar"));

        CompletableFuture<Void> future = repository.readAllBy().thenAccept(customers -> {
            assertThat(customers).hasSize(2);
            customers.forEach(customer -> log.info(customer.toString()));
            log.info("Completed!");
        });

        while (!future.isDone()) {
            log.info("Waiting for me CompletableFuture to finish...");
            TimeUnit.MILLISECONDS.sleep(500);
        }

        future.get();

        log.info("Done!");
    }
}
