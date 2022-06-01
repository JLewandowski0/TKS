package infrastructure.RentPorts;

import model.Rent;

import java.util.function.Predicate;

public interface GetRentPredicateInfrastructurePort {
    Rent get(Predicate<Rent> predicate);
}
