package infrastructure.RentPorts;

import model.Rent;

import java.util.UUID;

public interface GetRentInfrastructurePort {
    Rent get(UUID uuid);
}
