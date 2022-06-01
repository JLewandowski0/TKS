package infrastructure.RentPorts;

import model.Rent;

import java.util.UUID;
import java.util.function.Predicate;

public interface GetRentInfrastructurePort {
    Rent get(UUID uuid);
    Rent get(Predicate<Rent> predicate);
}
