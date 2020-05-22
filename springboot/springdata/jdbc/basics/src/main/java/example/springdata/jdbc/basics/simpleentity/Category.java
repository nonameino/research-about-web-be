package example.springdata.jdbc.basics.simpleentity;

import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
public class Category {

    @Id
    @Wither
    private final Long id;
}
