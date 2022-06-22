package Adapters;


import Repositiories.RentRepository;
import infrastructurePorts.RentPorts.AddRentInfrastructurePort;
import infrastructurePorts.RentPorts.GetAllRentInfrastructurePort;
import infrastructurePorts.RentPorts.GetRentInfrastructurePort;
import infrastructurePorts.RentPorts.RemoveRentInfrastructurePort;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tks.model.RentEnt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
@Component
public class RentRepositoryAdapter implements AddRentInfrastructurePort, GetAllRentInfrastructurePort, GetRentInfrastructurePort, RemoveRentInfrastructurePort {
    @Autowired
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
