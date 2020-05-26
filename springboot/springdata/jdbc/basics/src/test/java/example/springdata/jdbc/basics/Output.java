package example.springdata.jdbc.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Output {
    private static final Logger LOG = LoggerFactory.getLogger(Output.class);

    public static void list(Iterable<?> categories, String title) {
        StringBuilder message = new StringBuilder(String.format("==== %s ====\n", title));
        categories.forEach(category -> message.append(category.toString().replace(", ", ",\n\t")));
        LOG.info(message.toString());
    }
}
