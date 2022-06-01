package infrastructure.UserPorts;

import java.util.function.Predicate;
import model.User;

public interface GetUserPredicateInfrastructurePort {
    User get(Predicate<User> predicate);
}
