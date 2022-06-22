package services;


import exceptions.*;
import infrastructurePorts.RentPorts.*;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class RentService {

    private final GetAllRentInfrastructurePort getAllRentInfrastructurePort;

    private final GetRentInfrastructurePort getRentInfrastructurePort;

    private final RemoveRentInfrastructurePort removeRentInfrastructurePort;

    private final AddRentInfrastructurePort addRentInfrastructurePort;
    @Autowired
    public RentService(AddRentInfrastructurePort addRentInfrastructurePort, GetAllRentInfrastructurePort getAllRentInfrastructurePort, GetRentInfrastructurePort getRentInfrastructurePort, RemoveRentInfrastructurePort removeRentInfrastructurePort) {
        this.getAllRentInfrastructurePort = getAllRentInfrastructurePort;
        this.getRentInfrastructurePort = getRentInfrastructurePort;
        this.removeRentInfrastructurePort = removeRentInfrastructurePort;
        this.addRentInfrastructurePort = addRentInfrastructurePort;
    }

    public Rent addRent(Rent rent) {

        // może być null ponieważ RentMapper wywołuję metody get z repozytoriów, które zwracają obiekt lub null.

        if (rent.getBook() == null) {
            throw new BookNotFoundException("There is no book with given id!");
        }

        if (rent.getClient() == null) {
            throw new UserNotFoundException("There is no user with given id!");
        }

        if (this.findAllCurrentRentsByBook(rent.getBook().getUuid()).size() != 0) {
            throw new BookAlreadyRentedException("Book has been already rented!");
        }

        if (!rent.getClient().isActive()) {
            throw new UserNotActiveException("User is inactive!");
        }
        addRentInfrastructurePort.add(rent);

        return rent;
    }

    public Rent getRent(UUID uuid) {

        Rent rent = getRentInfrastructurePort.get(uuid);
        if (rent == null) {
            throw new RentNotFoundException("There is no rent with given id!");
        }
        return rent;
    }

    public List<Rent> getAllRents() {
        return getAllRentInfrastructurePort.getAll();
    }

    public void endRent(UUID uuid) {
        Rent rent = getRentInfrastructurePort.get(uuid);

        if (rent == null) {
            throw new RentNotFoundException("There is no rent with the given id!");
        }

        if (LocalDate.now().isBefore(rent.getStartDate())){
            throw new RentWrongDateException("Rent has not started yet!");
        }

        rent.setEndDate(LocalDate.now());
    }

    public void removeRent(UUID uuid) {
        Rent rent = getRentInfrastructurePort.get(uuid);

        if (rent == null) {
            throw new RentNotFoundException("There is no rent with the given id!");
        }

        if (rent.getEndDate() != null){
            throw new RentRemoveAfterEndedException("You cannot remove ended rent!");
        }

        removeRentInfrastructurePort.remove(rent);

    }

    public List<Rent> findAllCurrentRentsByClient(UUID userUuid) {
        return getAllRentInfrastructurePort.getAll(x -> x.getClient().getUuid().equals(userUuid) && x.getEndDate() == null);
    }

    public List<Rent> findAllCurrentRentsByBook(UUID bookUuid) {
        return getAllRentInfrastructurePort.getAll(x -> x.getBook().getUuid().equals(bookUuid) && x.getEndDate() == null);
    }

    public List<Rent> findAllArchivedRentsByClient(UUID userUuid) {
        return getAllRentInfrastructurePort.getAll(x -> x.getClient().getUuid().equals(userUuid) && x.getEndDate() != null);
    }

    public List<Rent> findAllArchivedRentsByBook(UUID bookUuid) {
        return getAllRentInfrastructurePort.getAll(x -> x.getBook().getUuid().equals(bookUuid) && x.getEndDate() != null);
    }

}
