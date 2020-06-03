package example.springdata.jpa.simple;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SimpleUserRepository extends CrudRepository<User, Long> {
    User findByTheUsersName(String username);
    Optional<User> findByUsername(Optional<String> username);
    List<User> findByLastname(String lastname);
    @Query("select u from User u where u.firstname = :firstname")
    List<User> findByFirstname(String firstname);
    @Query("select u from User u where u.firstname = :name or u.lastname = :name")
    List<User> findByFirstnameOrLastname(String name);
    Long removeByLastname(String lastname);
    Slice<User> findByLastnameOrderByUsernameAsc(String lastname, Pageable page);
    List<User> findFirst2ByOrderByLastnameAsc();
    List<User> findTop2By(Sort sort);
    @Query("select u from User u where u.firstname = :#{#user.firstname} or u.lastname = :#{#user.lastname}")
    Iterable<User> findByFirstnameOrLastname(User user);
}
