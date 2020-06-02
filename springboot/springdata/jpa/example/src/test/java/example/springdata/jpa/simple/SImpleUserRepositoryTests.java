package example.springdata.jpa.simple;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class SImpleUserRepositoryTests {
    @Autowired
    private SimpleUserRepository repository;

    User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
    }

    @Test
    public void findSaveUserById() {
        user = repository.save(user);
        assertThat(repository.findById(user.getId())).hasValue(user);
    }

    @Test
    public void findSaveUserByLastname() throws Exception {
        user = repository.save(user);
        assertThat(repository.findByLastname("lastname")).contains(user);
    }

    @Test
    public void findByFirstnameOrLastname() throws Exception {
        user = repository.save(user);
        assertThat(repository.findByFirstnameOrLastname("lastname")).contains(user);
    }

    @Test
    public void useOptionalAsReturnANdParameterType() {
        assertThat(repository.findByUsername(Optional.of("foobar"))).isEmpty();
        repository.save(user);
        assertThat(repository.findByUsername(Optional.of("foobar"))).isPresent();
    }

    @Test
    public void removeByLastname() {
        User user1 = new User();
        user1.setLastname(user.getLastname());

        User user2 = new User();
        user2.setLastname("no-positive-match");

        repository.saveAll(Arrays.asList(user, user1, user2));

        assertThat(repository.removeByLastname(user.getLastname())).isEqualTo(2L);
        assertThat(repository.existsById(user2.getId())).isTrue();
    }

    @Test
    public  void useSliceToLoadContent() {
        repository.deleteAll();

        int totalNumberUsers = 11;
        List<User> source = new ArrayList<>(totalNumberUsers);

        for(int i=1; i<=totalNumberUsers; i++) {
            User user1 = new User();
            user1.setLastname(user.getLastname());
            user1.setUsername(user.getLastname() + "-" + String.format("%03d", i));
            source.add(user1);
        }

        repository.saveAll(source);

        Slice<User> users = repository.findByLastnameOrderByUsernameAsc(user.getLastname(), PageRequest.of(1, 5));

        assertThat(users).containsAll(source.subList(5, 10));
    }

//    @Test
//    public void findFirst2ByOrderByLastnameAsc() {
//        User user1 = new User();
//        user1.setLastname("lastname-0");
//
//        User user2 = new User();
//        user2.setLastname("lastname-1");
//
//        User user3 = new User();
//        user3.setLastname("lastname-2");
//
//        repository.saveAll(Arrays.asList(user3, user2, user1));
//
//        List<User> result = repository.findFirst2ByOrderByLastnameAsc();
//
//        assertThat(result.size(), is(2));
//    }
}
