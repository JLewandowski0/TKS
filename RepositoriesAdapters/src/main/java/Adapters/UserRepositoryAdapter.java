package Adapters;

import Repositiories.UserRepository;
import infrastructure.UserPorts.AddUserInfrastructurePort;
import infrastructure.UserPorts.GetAllUsersInfrastructurePort;
import infrastructure.UserPorts.GetUserInfrastructurePort;
import infrastructure.UserPorts.RemoveUserInfrastructurePort;
import model.User;
import pl.tks.model.UserEnt;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class UserRepositoryAdapter implements AddUserInfrastructurePort, GetAllUsersInfrastructurePort, GetUserInfrastructurePort, RemoveUserInfrastructurePort {
    @Inject
    UserRepository userRepository;
    DomainMapper.UserMapper userDomainMapper;
    EntityMapper.UserMapper userEntityMapper;
    @Override
    public boolean add(User user) {
        UserEnt userEnt = userEntityMapper.ConvertUserToUserEnt(user);
        return userRepository.add(userEnt);
    }

    @Override
    public List<User> getAll() {
        List<UserEnt> userEntList = userRepository.getAll();
        List<User> userList = new ArrayList<>();
        for(UserEnt c : userEntList){
            userList.add(userDomainMapper.ConvertUserEntToUser(c));
        }
        return userList;
    }

    @Override
    public List<User> getAll(Predicate<User> predicate) {
        List<UserEnt> userEntList = userRepository.getAll();
        List<User> userList = new ArrayList<>();
        for(UserEnt c : userEntList){
            if(predicate.test(userDomainMapper.ConvertUserEntToUser(c))){
            userList.add(userDomainMapper.ConvertUserEntToUser(c));
            }
        }
        return userList;
    }

    @Override
    public User get(UUID uuid) {
        UserEnt userEnt = userRepository.get(uuid);
        return userDomainMapper.ConvertUserEntToUser(userEnt);
    }

    @Override
    public User get(Predicate<User> predicate) {
        List<UserEnt> userEntList = userRepository.getAll();
        for (UserEnt c : userEntList) {
        if(predicate.test(userDomainMapper.ConvertUserEntToUser(c)) && c.isActive()){
            return userDomainMapper.ConvertUserEntToUser(c);
            }
        }
        return null;
    }

    @Override
    public boolean remove(User user) {
       UserEnt userEnt = userEntityMapper.ConvertUserToUserEnt(user);
       return userRepository.remove(userEnt);
    }
}
