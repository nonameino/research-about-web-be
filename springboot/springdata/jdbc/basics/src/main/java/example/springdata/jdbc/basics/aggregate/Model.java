package example.springdata.jdbc.basics.aggregate;

import lombok.AccessLevel;
import lombok.Value;
import lombok.With;

@Value
@With(AccessLevel.PACKAGE)
public class Model {
    protected String name;
    protected String description;

    public Model(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
