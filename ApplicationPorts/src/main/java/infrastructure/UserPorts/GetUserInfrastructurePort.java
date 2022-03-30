package infrastructure.UserPorts;

import model.User;

import java.util.UUID;

public interface GetUserInfrastructurePort {
    User get(UUID uuid);
}
