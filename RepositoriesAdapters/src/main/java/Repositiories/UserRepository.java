package Repositiories;

import pl.tks.model.UserEnt;
import exceptions.UserNotUniqueIdException;
import exceptions.UserNotUniqueLoginException;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import static java.util.Collections.synchronizedList;

@ApplicationScoped
public class UserRepository implements Repository<UserEnt> {

    private final List<UserEnt> users = synchronizedList(new ArrayList<>());


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
    public List<UserEnt> getAll(Predicate<UserEnt> predicate) {
        List<UserEnt> ret = new ArrayList<>();
        for (UserEnt c : users) {
            if (predicate.test(c)) {
                ret.add(c);
            }
        }
        return ret;
    }

    @Override
    public List<UserEnt> getAll() {
        return users;
    }

}
