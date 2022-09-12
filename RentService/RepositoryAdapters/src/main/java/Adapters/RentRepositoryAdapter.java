package Adapters;


import DomainMapper.RentMapperDomain;
import EntityMapper.RentMapperEntity;
import RepoModel.RentEnt;
import Repository.RentRepository;
import infrastructurePorts.RentPorts.AddRentInfrastructurePort;
import infrastructurePorts.RentPorts.GetAllRentInfrastructurePort;
import infrastructurePorts.RentPorts.GetRentInfrastructurePort;
import infrastructurePorts.RentPorts.RemoveRentInfrastructurePort;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Component
public class RentRepositoryAdapter implements AddRentInfrastructurePort, GetAllRentInfrastructurePort, GetRentInfrastructurePort, RemoveRentInfrastructurePort {
    @Autowired
    RentRepository rentRepository;

    @Override
    public boolean add(Rent rent) {
        RentEnt rentEnt = RentMapperEntity.convertRentToRentEnt(rent);
        return rentRepository.add(rentEnt);
    }

    @Override
    public List<Rent> getAll() {
        List<RentEnt> rentEntList = rentRepository.getAll();
        List<Rent> rentList = new ArrayList<>();
        for(RentEnt c : rentEntList) {
            rentList.add(RentMapperDomain.convertRentEntToRent(c));
        }
        return rentList;
    }

    @Override
    public List<Rent> getAll(Predicate<Rent> predicate) {
        List<RentEnt> rentEntList = rentRepository.getAll();
        List<Rent> rentList = new ArrayList<>();
        for(RentEnt c : rentEntList){
            if(predicate.test(RentMapperDomain.convertRentEntToRent(c))){
                rentList.add(RentMapperDomain.convertRentEntToRent(c));
            }
        }
        return rentList;
    }

    @Override
    public Rent get(UUID uuid) {
        RentEnt rentEnt = rentRepository.get(uuid);
        return RentMapperDomain.convertRentEntToRent(rentEnt);
    }

    @Override
    public Rent get(Predicate<Rent> predicate) {
        List<RentEnt> rentEntList = rentRepository.getAll();
        for(RentEnt c : rentEntList){
            if(predicate.test(RentMapperDomain.convertRentEntToRent(c))){
                return RentMapperDomain.convertRentEntToRent(c);
            }
        }
        return null;
    }

    @Override
    public boolean remove(Rent rent) {
        RentEnt rentEnt = RentMapperEntity.convertRentToRentEnt(rent);
        return rentRepository.remove(rentEnt);
    }

    @Override
    public Rent endRent(UUID uuid) {
        RentEnt rentEnt = rentRepository.endRent(uuid);
        return RentMapperDomain.convertRentEntToRent(rentEnt);
    }
}
