package example.springdata.jdbc.basics.simpleentity;

public interface WithInsert<T> {
    T insert(T t);
}
