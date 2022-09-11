package Adapters;

import DomainMapper.UserMapperDomain;
import EntityMapper.UserMapperEntity;
import Repository.UserRepository;
import infrastructurePorts.UserPorts.AddUserInfrastructurePort;
import infrastructurePorts.UserPorts.GetAllUsersInfrastructurePort;
import infrastructurePorts.UserPorts.GetUserInfrastructurePort;
import infrastructurePorts.UserPorts.RemoveUserInfrastructurePort;
import model.User;
import RepoModel.UserEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Component
public class UserRepositoryAdapter implements AddUserInfrastructurePort, GetAllUsersInfrastructurePort, GetUserInfrastructurePort, RemoveUserInfrastructurePort {
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean add(User user) {
        UserEnt userEnt = UserMapperEntity.convertUserToUserEnt(user);
        return userRepository.add(userEnt);
    }

    @Override
    public List<User> getAll() {
        List<UserEnt> userEntList = userRepository.getAll();
        List<User> userList = new ArrayList<>();
        for(UserEnt c : userEntList){
            userList.add(UserMapperDomain.convertUserEntToUser(c));
        }
        return userList;
    }

    @Override
    public List<User> getAll(Predicate<User> predicate) {
        List<UserEnt> userEntList = userRepository.getAll();
        List<User> userList = new ArrayList<>();
        for(UserEnt c : userEntList){
            if(predicate.test(UserMapperDomain.convertUserEntToUser(c))){
            userList.add(UserMapperDomain.convertUserEntToUser(c));
            }
        }
        return userList;
    }

    @Override
    public User get(UUID uuid) {
        UserEnt userEnt = userRepository.get(uuid);
        return UserMapperDomain.convertUserEntToUser(userEnt);
    }

    @Override
    public User get(Predicate<User> predicate) {
        List<UserEnt> userEntList = userRepository.getAll();
        for (UserEnt c : userEntList) {
        if(predicate.test(UserMapperDomain.convertUserEntToUser(c)) && c.isActive()){
            return UserMapperDomain.convertUserEntToUser(c);
            }
        }
        return null;
    }

    @Override
    public boolean remove(User user) {
       UserEnt userEnt = UserMapperEntity.convertUserToUserEnt(user);
       return userRepository.remove(userEnt);
    }
}
