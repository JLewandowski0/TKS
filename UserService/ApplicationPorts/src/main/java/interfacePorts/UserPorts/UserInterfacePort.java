package interfacePorts.UserPorts;

import model.User;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface UserInterfacePort<T>{
    List <T> getAll();
    T get(UUID uuid);

    T findUser(String login);

    boolean add(T user);
    boolean remove(UUID uuid);
}
