package services;


import exceptions.UserNotActiveException;
import exceptions.UserNotFoundException;
import exceptions.UserNotUniqueLoginException;
import exceptions.UserUsedInCurrentRentException;
import infrastructurePorts.RentPorts.GetAllRentInfrastructurePort;
import infrastructurePorts.UserPorts.AddUserInfrastructurePort;
import infrastructurePorts.UserPorts.GetAllUsersInfrastructurePort;
import infrastructurePorts.UserPorts.GetUserInfrastructurePort;
import infrastructurePorts.UserPorts.RemoveUserInfrastructurePort;
import model.AccessLevel;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    private final GetAllUsersInfrastructurePort getAllUsersInfrastructurePort;

    private final GetUserInfrastructurePort getUserInfrastructurePort;

    private final AddUserInfrastructurePort addUserInfrastructurePort;

    private final RemoveUserInfrastructurePort removeUserInfrastructurePort;

    private final GetAllRentInfrastructurePort getAllRentInfrastructurePort;
@Autowired
    public UserService(GetAllUsersInfrastructurePort getAllUsersInfrastructurePort, GetUserInfrastructurePort getUserInfrastructurePort, AddUserInfrastructurePort addUserInfrastructurePort, RemoveUserInfrastructurePort removeUserInfrastructurePort, GetAllRentInfrastructurePort getAllRentInfrastructurePort) {
        this.getAllUsersInfrastructurePort = getAllUsersInfrastructurePort;
        this.getUserInfrastructurePort = getUserInfrastructurePort;
        this.addUserInfrastructurePort = addUserInfrastructurePort;
        this.removeUserInfrastructurePort = removeUserInfrastructurePort;
        this.getAllRentInfrastructurePort = getAllRentInfrastructurePort;
    }
    public boolean addUser(User user) {
        return addUserInfrastructurePort.add(user);
    }

    public User getUser(UUID uuid) {
        User user = getUserInfrastructurePort.get(uuid);
        if (user == null) {
            throw new UserNotFoundException("There is no user with given uuid!");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return getAllUsersInfrastructurePort.getAll();
    }

    public User findUser(String login) {
        User user = getUserInfrastructurePort.get(x -> x.getLogin().equals(login));
        if (user == null) {
            throw new UserNotFoundException("There is no user with given login!");
        }
        return user;
    }

    public List<User> findAllUsers(String partOfLogin) {
        return getAllUsersInfrastructurePort.getAll(x -> x.getLogin().contains(partOfLogin));
    }

    public void updateUser(UUID uuid, User updatedUser) {
        User user = getUserInfrastructurePort.get(uuid);
        if (user == null) {
            throw new UserNotFoundException("There is no user with given login!");
        }
        user.setAddress(updatedUser.getAddress());
        user.setPesel(updatedUser.getPesel());
        user.setAccessLevel(AccessLevel.valueOf(updatedUser.getAccessLevel()));

        if (!updatedUser.getLogin().equals(user.getLogin())) {
            if (getUserInfrastructurePort.get(x -> x.getLogin().equals(updatedUser.getLogin())) != null) {
                throw new UserNotUniqueLoginException("User with given login already exist!");
           }
            user.setLogin(updatedUser.getLogin());
        }
    }

    public boolean changeActivityOfUser(UUID uuid, boolean var) {
        User user = getUserInfrastructurePort.get(uuid);
        if (user == null) {
            throw new UserNotFoundException("There is no user with given uuid!");
        }
        if (user.isActive() && var) {
            throw new UserNotActiveException("This user is already active!");
        }
        if (!user.isActive() && !var) {
            throw new UserNotActiveException("This user is already inactive!");
        }

        if (getAllRentInfrastructurePort.getAll(x -> x.getClient().getUuid().equals(uuid) && x.getEndDate() == null).size() != 0  ) {
            throw new UserUsedInCurrentRentException("You cannot deactivate this user because he has not end his rent yet!");
        }

        user.changeActivity();
        return true;

    }


}
