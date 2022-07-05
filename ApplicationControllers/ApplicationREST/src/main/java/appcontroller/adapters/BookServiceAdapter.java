package appcontroller.adapters;

import appcontroller.mappers.BookMapper;
import appcontroller.modelDto.BookDto;
import interfacePorts.BookPorts.BookInterfacePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.BookService;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Service
public class BookServiceAdapter implements BookInterfacePort<BookDto> {

    @Autowired
    BookService bookService;

    @Override
    public List<BookDto> getAll() {
        return bookService
                .getAllBooks()
                .stream()
                .map(BookMapper::convertBookToBookDto)
                .toList();
    }

    @Override
    public List<BookDto> get(Predicate<String> predicate) {
        return null;
    }


    @Override
    public BookDto get(UUID uuid) {
        return BookMapper.convertBookToBookDto(bookService.getBook(uuid));
    }

    @Override
    public boolean add(BookDto bookDto) {
        return bookService.addBook(BookMapper.convertBookDtoToBook(bookDto));
    }


    @Override
    public boolean remove(UUID uuid) {

        return bookService.removeBook(uuid);
    }
}
