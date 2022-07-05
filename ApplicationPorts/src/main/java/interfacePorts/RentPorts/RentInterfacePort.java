package interfacePorts.RentPorts;

import model.Rent;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface RentInterfacePort<T> {
    T get(UUID uuid);
    T get(Predicate<T> predicate);
    boolean add(T rent);
    List<T> getAll();
    boolean remove(UUID uuid);

    T endRent(UUID uuid);
}
