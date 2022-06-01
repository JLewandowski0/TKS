package services;


import infrastructure.RentPorts.GetAllRentPredicateInfrastructurePort;
import infrastructure.UserPorts.*;
import exceptions.*;

import model.AccessLevel;
import model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Stateless
public class UserService {


    @Inject
    private RentService rentService;

    @Inject
    GetAllUsersInfrastructurePort getAllUsersInfrastructurePort;

    @Inject
    GetUserInfrastructurePort getUserInfrastructurePort;

    @Inject
    AddUserInfrastructurePort addUserInfrastructurePort;

    @Inject
    RemoveUserInfrastructurePort removeUserInfrastructurePort;

    @Inject
    GetAllUsersPredicateInfrastructurePort getAllUsersPredicateInfrastructurePort;

    @Inject
    GetUserPredicateInfrastructurePort getUserPredicateInfrastructurePort;

    public User addUser(User user) {
        addUserInfrastructurePort.add(user);
        return user;
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
        User user = getUserPredicateInfrastructurePort.get(x -> x.getLogin().equals(login));
        if (user == null) {
            throw new UserNotFoundException("There is no user with given login!");
        }
        return user;
    }

    public List<User> findAllUsers(String partOfLogin) {
        return getAllUsersPredicateInfrastructurePort.getAll(x -> x.getLogin().contains(partOfLogin));
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
            if (getUserPredicateInfrastructurePort.get(x -> x.getLogin().equals(updatedUser.getLogin())) != null) {
                throw new UserNotUniqueLoginException("User with given login already exist!");
           }
            user.setLogin(updatedUser.getLogin());
        }
    }

    public void changeActivityOfUser(UUID uuid, boolean var) {
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

        if (rentService.getAllRentPredicateInfrastructurePort.getAll(x -> x.getClient().getUuid().equals(uuid) && x.getEndDate() == null).size() != 0  ) {
            throw new UserUsedInCurrentRentException("You cannot deactivate this user because he has not end his rent yet!");
        }

        user.changeActivity();

    }

//  usuwanie użytkowników działało w ten sam sposób jak w przypadku książek. (Posiadł on pole archived, repo odpowiednio filtrowały użytkowników)

//    public void removeUser(UUID uuid) {
//        User user = userRepository.get(uuid);
//
//        if (user == null) {
//            throw new UserNotFoundException("There is no user with given uuid!");
//        }
//
//        if (rentRepository.getAll(x -> x.getClient().getUuid().equals(uuid)).size() != 0) {
//            throw new UserUsedInCurrentRentException("This user has not end his rent yet!");
//        }
//        userRepository.remove(user);
//    }


}
