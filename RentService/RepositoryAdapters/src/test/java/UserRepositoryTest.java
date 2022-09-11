import RepoModel.AccessLevelEnt;
import RepoModel.ClientEnt;
import RepoModel.UserEnt;
import Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserRepositoryTest {
    UserRepository userRepository;

    @BeforeEach
    void init() {
        userRepository = new UserRepository();
    }

    @Test
    void addUserTest() {
        int size = userRepository.getAll().size();
        userRepository.add(new ClientEnt(UUID.randomUUID(), "test", "test", "test", AccessLevelEnt.CLIENT));
        assertEquals(userRepository.getAll().size(),size + 1);
    }
    @Test
    void deleteUserTest(){
        int size = userRepository.getAll().size();
        UUID uuid = UUID.randomUUID();
        ClientEnt clientEnt = new ClientEnt(uuid, "test", "test", "test", AccessLevelEnt.CLIENT);
        userRepository.add(clientEnt);
        userRepository.remove(clientEnt);
        assertEquals(userRepository.getAll().size(),size);
    }

    @Test
    void getUserTest(){
        UUID uuid = UUID.randomUUID();
        ClientEnt clientEnt = new ClientEnt(uuid, "test", "test", "test", AccessLevelEnt.CLIENT);
        userRepository.add(clientEnt);
        assertNotEquals(userRepository.get(uuid),clientEnt);
    }

    @Test
    void getAllUsersTest(){
        int size = userRepository.getAll().size();
        userRepository.add(new ClientEnt(UUID.randomUUID(), "test", "test", "test", AccessLevelEnt.CLIENT));
        assertEquals(userRepository.getAll().size(),size + 1);
    }


}
