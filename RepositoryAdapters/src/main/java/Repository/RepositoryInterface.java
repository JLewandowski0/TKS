package Repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
@Repository
public interface RepositoryInterface<T> {
    T get(UUID uuid);
    boolean add(T t) throws RuntimeException;
    boolean remove(T t);
    T get(Predicate<T> predicate);
    List<T> getAll();

}
