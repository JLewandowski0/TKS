package interfacePorts.BookPorts;

import model.Book;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface BookInterfacePort<T> {
    List<T> getAll();
    List<T> get(Predicate<String> predicate);
    T get(UUID uuid);
    boolean add(T book);
    boolean remove(UUID uuid);
}
