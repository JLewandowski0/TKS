package pl.tks.model;

import java.time.LocalDate;
import java.util.UUID;


public class RentEnt {

    private UUID uuid;
    private LocalDate startDate;
    private LocalDate endDate = null;
    private UserEnt client;
    private BookEnt book;

    public RentEnt(LocalDate startDate, UserEnt client, BookEnt book) {
        this.uuid = UUID.randomUUID();
        this.startDate = startDate;
        this.client = client;
        this.book = book;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public UserEnt getClient() {
        return client;
    }

    public BookEnt getBook() {
        return book;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
