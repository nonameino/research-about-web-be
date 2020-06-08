package example.springdata.jpa.interceptors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterceptorIntegrationTest {
    @Autowired
    private CustomerRepository repository;

    @Test
    public void foo() {
        Customer customer = new Customer();
        customer.setFirstname("Dave");
        customer.setLastname("Matthews");
        repository.save(customer);
    }
}
