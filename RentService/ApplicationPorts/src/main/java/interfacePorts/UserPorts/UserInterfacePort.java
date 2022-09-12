package interfacePorts.UserPorts;

import java.util.List;
import java.util.UUID;

public interface UserInterfacePort<T>{
    List <T> getAll();
    T get(UUID uuid);

    T findUser(String login);

    boolean add(T user);
    boolean remove(UUID uuid);
}
