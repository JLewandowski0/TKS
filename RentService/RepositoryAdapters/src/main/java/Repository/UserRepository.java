package Repository;

import RepoModel.AccessLevelEnt;
import RepoModel.AdminUserEnt;
import RepoModel.ClientEnt;
import RepoModel.UserEnt;
import exceptions.UserNotUniqueIdException;
import exceptions.UserNotUniqueLoginException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Repository
public class UserRepository implements RepositoryInterface<UserEnt> {

    private final List<UserEnt> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        this.add(new AdminUserEnt(UUID.fromString("9f77375c-7d30-4eca-a830-3ebec2ddd8a7"),"John", "Doe", "0000000000", AccessLevelEnt.ADMINUSER));
        this.add(new ClientEnt(UUID.fromString("9f77375c-7d30-4eca-a830-cabec2ddd8a7"),"Jane", "Doe", "1111111111", AccessLevelEnt.CLIENT));
        this.add(new ClientEnt(UUID.fromString("9f77375c-7d30-4eca-a830-bfbec2ddd8a7"),"Jack", "Doe", "2222222222", AccessLevelEnt.CLIENT));
    }

    @Override
    public boolean add(UserEnt user) {
        user.setUuid(UUID.randomUUID());
        if (user.getUuid() == null || this.get(user.getUuid()) != null) {
            throw new UserNotUniqueIdException("User with given uuid already exist!");
        }
        if (this.get(x -> x.getLogin().equals(user.getLogin())) != null) {
            throw new UserNotUniqueLoginException("User with given login already exist!");
        }

        return users.add(user);
    }

    //NIGDY NIE UZYTE!
    @Override
    public boolean remove(UserEnt user) {
        return users.remove(user);
    }

    @Override
    public UserEnt get(UUID uuid) {
        for (UserEnt c : users) {
            if (c.getUuid().equals(uuid)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public UserEnt get(Predicate<UserEnt> predicate) {
        for (UserEnt c : users) {
            if (predicate.test(c)) {
                return c;
            }
        }
        return null;
    }


    @Override
    public List<UserEnt> getAll() {
        return users;
    }

}
