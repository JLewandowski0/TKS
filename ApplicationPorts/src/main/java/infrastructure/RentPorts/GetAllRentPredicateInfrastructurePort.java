package infrastructure.RentPorts;

import model.Rent;

import java.util.List;
import java.util.function.Predicate;

public interface GetAllRentPredicateInfrastructurePort {
    List<Rent> getAll(Predicate<Rent> predicate);
}
