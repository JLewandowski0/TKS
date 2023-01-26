package appcontroller.api;

import appcontroller.adapters.UserServiceAdapter;
import appcontroller.modelDto.UserDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
@Autowired
    private final UserServiceAdapter userServiceAdapter;

    public UserController(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }

    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> readAllUser() {
        return userServiceAdapter.getAll();
    }

    @GetMapping(value ="/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto readUser(@PathVariable("uuid") String uuid) {
        return userServiceAdapter.get(UUID.fromString(uuid));
    }

    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody UserDto user) {
        try{
            userServiceAdapter.add(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/login/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findUser(@PathVariable("login") String login) {
        try {
            return userServiceAdapter.findUser(login);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @RabbitListener(queues = "user_rent")
    public void rabbitListener(UserDto userDto) {
        try {
            System.out.println(userDto);
            userServiceAdapter.add(userDto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}