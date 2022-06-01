package Adapters;


import Repositiories.RentRepository;
import infrastructure.RentPorts.AddRentInfrastructurePort;
import infrastructure.RentPorts.GetAllRentInfrastructurePort;
import infrastructure.RentPorts.GetRentInfrastructurePort;
import infrastructure.RentPorts.RemoveRentInfrastructurePort;
import model.Rent;
import pl.tks.model.RentEnt;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class RentRepositoryAdapter implements AddRentInfrastructurePort, GetAllRentInfrastructurePort, GetRentInfrastructurePort, RemoveRentInfrastructurePort {
    @Inject
    RentRepository rentRepository;
    DomainMapper.RentMapper rentDomainMapper;
    EntityMapper.RentMapper rentEntityMapper;

    @Override
    public boolean add(Rent rent) {
        RentEnt rentEnt = rentEntityMapper.convertRentToRentEnt(rent);
        return rentRepository.add(rentEnt);
    }

    @Override
    public List<Rent> getAll() {
        List<RentEnt> rentEntList = rentRepository.getAll();
        List<Rent> rentList = new ArrayList<>();
        for(RentEnt c : rentEntList) {
            rentList.add(rentDomainMapper.convertRentEntToRent(c));
        }
        return rentList;
    }

    @Override
    public List<Rent> getAll(Predicate<Rent> predicate) {
        List<RentEnt> rentEntList = rentRepository.getAll();
        List<Rent> rentList = new ArrayList<>();
        for(RentEnt c : rentEntList){
            if(predicate.test(rentDomainMapper.convertRentEntToRent(c))){
                rentList.add(rentDomainMapper.convertRentEntToRent(c));
            }
        }
        return rentList;
    }

    @Override
    public Rent get(UUID uuid) {
        RentEnt rentEnt = rentRepository.get(uuid);
        return rentDomainMapper.convertRentEntToRent(rentEnt);
    }

    @Override
    public Rent get(Predicate<Rent> predicate) {
        List<RentEnt> rentEntList = rentRepository.getAll();
        for(RentEnt c : rentEntList){
            if(predicate.test(rentDomainMapper.convertRentEntToRent(c))){
                return rentDomainMapper.convertRentEntToRent(c);
            }
        }
        return null;
    }

    @Override
    public boolean remove(Rent rent) {
        RentEnt rentEnt = rentEntityMapper.convertRentToRentEnt(rent);
        return rentRepository.remove(rentEnt);
    }
}
