package example.springdata.jdbc.basics.simpleentity;

import example.springdata.jdbc.basics.aggregate.AgeGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDateTime;

@Data
public class Category {

    @Id
    private final Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    @Getter
    private long inserted;
    private AgeGroup ageGroup;

    public Category(String name, String description, AgeGroup ageGroup) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.ageGroup = ageGroup;
        this.created = LocalDateTime.now();
    }

    public void timeStamp() {
        if (inserted == 0) {
            inserted = System.currentTimeMillis();
        }
    }
}
