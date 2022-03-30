package infrastructure.UserPorts;

import model.User;

import java.util.List;
import java.util.function.Predicate;

public interface GetAllUsersPredicateInfrastructurePort {
    List<User> getAll(Predicate<User> predicate);
}
