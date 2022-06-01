package infrastructure.RentPorts;
import model.Rent;

import java.util.List;
import java.util.function.Predicate;

public interface GetAllRentInfrastructurePort {
    List<Rent> getAll();
    List<Rent> getAll(Predicate<Rent> predicate);
}
