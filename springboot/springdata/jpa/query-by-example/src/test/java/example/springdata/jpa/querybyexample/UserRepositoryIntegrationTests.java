package example.springdata.jpa.querybyexample;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import org.springframework.data.domain.ExampleMatcher.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryIntegrationTests {

    @Autowired
    private UserRepository repository;

    User skyler, walter, flynn, marie, hank;

    @Before
    public void setUp() {
        repository.deleteAll();

        this.skyler = repository.save(new User("Skyler", "White", 45));
        this.walter = repository.save(new User("Walter", "White", 50));
        this.flynn = repository.save(new User("Walter Jr. (Flynn)", "White", 17));
        this.marie = repository.save(new User("Marie", "Shrader", 38));
        this.hank = repository.save(new User("Hank", "Shrander", 43));
    }

    @Test
    public  void countBySimpleExample() {
        Example<User> example = Example.of(new User(null, "White", null));
        assertThat(repository.count(example)).isEqualTo(3L);
    }

    @Test
    public void ignorePropertiesAndMatchByAge() {
        Example<User> example = Example.of(flynn, ExampleMatcher.matching().withIgnorePaths("firstname", "lastname"));
        assertThat(repository.findOne(example)).contains(flynn);
    }

//    @Test
//    public void configuringMatchersUsingLambdas() {
//        Example<User> example = Example.of(new User("Walter", "WHITE", null), ExampleMatcher.matching()
//            .withIgnorePaths("age")
//            .withMatcher("firstname", matcher -> matcher.startsWith())
//            .withMatcher("lastname", matcher -> matcher.endsWith()));
//
//        Assertions.assertThat(repository.findOne(example)).containsExactlyInAnyOrder(flynn, walter);
//    }
}
