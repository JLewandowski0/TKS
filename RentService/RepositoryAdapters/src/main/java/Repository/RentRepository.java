package Repository;

import RepoModel.RentEnt;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import static java.util.Collections.synchronizedList;

@Repository
public class RentRepository implements RepositoryInterface<RentEnt> {

    private final List<RentEnt> rents = synchronizedList(new ArrayList<>());

    @Override
    public boolean add(RentEnt rent) {
        rent.setUuid(UUID.randomUUID());
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

    public RentEnt endRent(UUID uuid) {
        for (RentEnt c : rents) {
            if (c.getUuid().equals(uuid)) {
                c.setEndDate(LocalDate.now());
                return c;
            }
        }
        return null;
    }

    @Override
    public List<RentEnt> getAll() {
        return rents;
    }

}
