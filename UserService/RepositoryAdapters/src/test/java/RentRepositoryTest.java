import RepoModel.AccessLevelEnt;
import RepoModel.BookEnt;
import RepoModel.ClientEnt;
import RepoModel.RentEnt;
import Repository.RentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RentRepositoryTest {
    RentRepository rentRepository;

    @BeforeEach
    void init() {
        rentRepository = new RentRepository();
    }

    @Test
    void addRentTest() {
        int size = rentRepository.getAll().size();
        BookEnt bookEnt = new BookEnt(UUID.randomUUID(),"test","test", LocalDate.now());
        ClientEnt clientEnt = new ClientEnt(UUID.randomUUID(), "test", "test", "test", AccessLevelEnt.CLIENT);
        rentRepository.add(new RentEnt(LocalDate.now(),clientEnt, bookEnt));
        assertEquals(rentRepository.getAll().size(),size + 1);
    }

    @Test
    void deleteRentTest(){
        int size = rentRepository.getAll().size();
        BookEnt bookEnt = new BookEnt(UUID.randomUUID(),"test","test", LocalDate.now());
        ClientEnt clientEnt = new ClientEnt(UUID.randomUUID(), "test", "test", "test", AccessLevelEnt.CLIENT);
        RentEnt rentEnt = new RentEnt(LocalDate.now(),clientEnt, bookEnt);
        rentRepository.add(rentEnt);
        rentRepository.remove(rentEnt);
        assertNotEquals(rentRepository.getAll().size(),size+1);
    }

    @Test
    void getRentAllRentTest(){
        UUID uuid = UUID.randomUUID();
        LocalDate date = LocalDate.now();
        BookEnt bookEnt = new BookEnt(uuid,"test","test", date);
        ClientEnt clientEnt = new ClientEnt(UUID.randomUUID(), "test", "test", "test", AccessLevelEnt.CLIENT);
        RentEnt rentEnt = new RentEnt(date,clientEnt, bookEnt);
        RentEnt rentEnt2 = new RentEnt(date,clientEnt, bookEnt);
        rentRepository.add(rentEnt);
        rentRepository.add(rentEnt2);
        assertEquals(rentRepository.getAll().size(),2);
    }
}
