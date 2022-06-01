package User;

import Repositiories.UserRepository;
import infrastructure.UserPorts.AddUserInfrastructurePort;
import infrastructure.UserPorts.GetAllUsersInfrastructurePort;
import infrastructure.UserPorts.GetUserInfrastructurePort;
import infrastructure.UserPorts.RemoveUserInfrastructurePort;
import model.User;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class UserRepositoryAdapter implements AddUserInfrastructurePort, GetUserInfrastructurePort, RemoveUserInfrastructurePort, GetAllUsersInfrastructurePort {

    @Inject
    private UserRepository repository;

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAll(Predicate<User> predicate) {
        return null;
    }

    @Override
    public User get(UUID uuid) {
        return null;
    }

    @Override
    public User get(Predicate<User> predicate) {
        return null;
    }

    @Override
    public boolean remove(User user) {
        return false;
    }
}
