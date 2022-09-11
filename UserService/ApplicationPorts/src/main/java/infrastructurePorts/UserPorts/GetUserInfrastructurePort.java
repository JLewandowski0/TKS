package infrastructurePorts.UserPorts;

import model.User;

import java.util.UUID;
import java.util.function.Predicate;

public interface GetUserInfrastructurePort {
    User get(UUID uuid);
    User get(Predicate<User> predicate);
}
