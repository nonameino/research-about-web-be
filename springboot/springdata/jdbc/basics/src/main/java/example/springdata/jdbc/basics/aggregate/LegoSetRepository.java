package example.springdata.jdbc.basics.aggregate;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LegoSetRepository extends CrudRepository<LegoSet, Integer> {
    @Query("SELECT m.name model_name, m.description, l.name set_name" +
                " FROM model m" +
                " JOIN lego_set l" +
                " ON m.lego_set = l.id" +
                " WHERE :age BETWEEN l.min_age and l.max_age")
    List<ModelReport> reportModelForAge(@Param("age") int age);

    @Modifying
    @Query("UPDATE model set name = lower(name) WHERE name <> lower(name)")
    int lowerCaseMapKeys();
}
