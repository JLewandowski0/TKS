package infrastructurePorts.RentPorts;

import model.Rent;

import java.util.UUID;

public interface RemoveRentInfrastructurePort {
    boolean remove(Rent rent);

    Rent endRent(UUID uuid);
}
