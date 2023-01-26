package appcontroller.api;

import appcontroller.adapters.BookServiceAdapter;
import appcontroller.modelDto.BookDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookServiceAdapter bookServiceAdapters;

    @Autowired
    public BookController(BookServiceAdapter bookServiceAdapter) {
        this.bookServiceAdapters = bookServiceAdapter;
    }

    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> readAllBook() {
        return bookServiceAdapters.getAll();
    }

    @GetMapping(value ="/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto readBook(@PathVariable("uuid") String uuid) {
        return bookServiceAdapters.get(UUID.fromString(uuid));
    }

    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBook(@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("releaseDate") String releaseDate) {
        try{
            BookDto book = new BookDto(title, author, releaseDate);
            book.setUuid(UUID.randomUUID().toString());
            bookServiceAdapters.add(book);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RabbitListener(queues = "book")
    public void rabbitListener(BookDto bookDto){
        try{
            bookDto.setUuid(UUID.randomUUID().toString());
            bookServiceAdapters.add(bookDto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
