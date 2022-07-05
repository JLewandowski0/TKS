package appcontroller.adapters;

import appcontroller.mappers.RentMapper;
import appcontroller.modelDto.RentDto;
import interfacePorts.RentPorts.RentInterfacePort;
import model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.RentService;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
@Service
public class RentServiceAdapter implements RentInterfacePort<RentDto> {

    @Autowired
    RentService rentService;

    @Override
    public RentDto get(UUID uuid) {
        return RentMapper.convertRentToRentDto(rentService.getRent(uuid));
    }

    @Override
    public RentDto get(Predicate<RentDto> predicate) {
        return null;
    }

    @Override
    public boolean add(RentDto rentDto) {
        return rentService.addRent(RentMapper.convertRentDtoToRent(rentDto));
    }

    @Override
    public List<RentDto> getAll() {
        return rentService
                .getAllRents()
                .stream()
                .map(RentMapper::convertRentToRentDto)
                .toList();
    }

    @Override
    public boolean remove(UUID uuid) {
        return rentService.removeRent(uuid);
    }

    @Override
    public RentDto endRent(UUID uuid) {
        Rent rent = rentService.endRent(uuid);
        return RentMapper.convertRentToRentDto(rent);
    }
}
