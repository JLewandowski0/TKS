package Repositiories;

import pl.tks.model.RentEnt;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import static java.util.Collections.synchronizedList;

@ApplicationScoped
public class RentRepository implements Repository<RentEnt> {

    private final List<RentEnt> rents = synchronizedList(new ArrayList<>());

    public RentRepository() {
    }

    @Override
    public boolean add(RentEnt rent) {
        if (rent.getUuid() == null || this.get(rent.getUuid()) != null) {
            throw new RuntimeException();
        }

        return rents.add(rent);
    }

    @Override
    public boolean remove(RentEnt rent) {
        return rents.remove(rent);
    }

    @Override
    public RentEnt get(UUID uuid) {
        for (RentEnt c : rents) {
            if (c.getUuid().equals(uuid)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public RentEnt get(Predicate<RentEnt> predicate) {
        for (RentEnt c : rents) {
            if (predicate.test(c)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<RentEnt> getAll(Predicate<RentEnt> predicate) {
        List<RentEnt> ret = new ArrayList<>();

        for (RentEnt c : rents) {
            if (predicate.test(c)) {
                ret.add(c);
            }
        }
        return ret;
    }

    @Override
    public List<RentEnt> getAll() {
        return rents;
    }

}
