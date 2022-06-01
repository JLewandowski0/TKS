package infrastructure.UserPorts;

import model.User;

import java.util.List;
import java.util.function.Predicate;

public interface GetAllUsersInfrastructurePort {
    List<User> getAll();
    List<User> getAll(Predicate<User> predicate);
}
