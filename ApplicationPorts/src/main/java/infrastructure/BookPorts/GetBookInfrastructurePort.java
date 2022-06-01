package infrastructure.BookPorts;

import model.Book;

import java.util.UUID;

public interface GetBookInfrastructurePort {
    Book get(UUID uuid);
}
