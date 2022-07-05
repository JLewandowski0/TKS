package appcontroller.adapters;

import appcontroller.mappers.UserMapper;
import appcontroller.modelDto.UserDto;
import interfacePorts.UserPorts.UserInterfacePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.UserService;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceAdapter implements UserInterfacePort<UserDto> {

    @Autowired
    UserService userService;

    @Override
    public List<UserDto> getAll() {
        return userService
                .getAllUsers()
                .stream()
                .map(UserMapper::convertUserToUserDto)
                .toList();
    }

    @Override
    public UserDto get(UUID uuid) {
        return UserMapper.convertUserToUserDto(userService.getUser(uuid));
    }

    @Override
    public UserDto findUser(String login) {
        return UserMapper.convertUserToUserDto(userService.findUser(login));
    }


    @Override
    public boolean add(UserDto userDto) {
        return userService.addUser(UserMapper.convertUserDtoToUser(userDto));
    }

    @Override
    public boolean remove(UUID uuid) {
        boolean activity = false;
        return userService.changeActivityOfUser(uuid, activity);
    }

}

