package Repository;

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
        this.add(new UserEnt(UUID.fromString("9f77375c-7d30-4eca-a830-3ebec2ddd8a7"),"John"));
        this.add(new UserEnt(UUID.fromString("9f77375c-7d30-4eca-a830-cabec2ddd8a7"),"Jane"));
        this.add(new UserEnt(UUID.fromString("9f77375c-7d30-4eca-a830-bfbec2ddd8a7"),"Jack"));
    }

    @Override
    public boolean add(UserEnt user) {
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
