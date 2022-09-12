package appcontroller.api;

import appcontroller.adapters.RentServiceAdapter;
import appcontroller.modelDto.RentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rent")
public class RentController {

    public final RentServiceAdapter rentServiceAdapter;

    @Autowired
    public RentController(RentServiceAdapter rentServiceAdapter) {
        this.rentServiceAdapter = rentServiceAdapter;
    }

    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> readAllRent() {
        return rentServiceAdapter.getAll();
    }

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto get(@PathVariable("uuid") String uuid) {
        return rentServiceAdapter.get(UUID.fromString(uuid));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody RentDto rentDto) {
        try{
            rentServiceAdapter.add(rentDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto endRent(@PathVariable("uuid") String uuid) {
        try{
            return rentServiceAdapter.endRent(UUID.fromString(uuid));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
