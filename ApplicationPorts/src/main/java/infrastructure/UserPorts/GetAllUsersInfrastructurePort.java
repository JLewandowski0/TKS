package infrastructure.UserPorts;

import model.User;

import java.util.List;

public interface GetAllUsersInfrastructurePort {
    List<User> getAll();
}
