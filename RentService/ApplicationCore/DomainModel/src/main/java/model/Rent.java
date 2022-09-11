package model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Rent {

    private UUID uuid;
    private LocalDate startDate;
    private LocalDate endDate;
    private User user;
    private Book book;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rent)) return false;
        Rent rent = (Rent) o;
        return Objects.equals(getUuid(), rent.getUuid()) &&
                Objects.equals(getBook(), rent.getBook()) &&
                Objects.equals(getUser(), rent.getUser()) &&
                Objects.equals(getStartDate(), rent.getStartDate()) &&
                Objects.equals(getEndDate(), rent.getEndDate());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getBook(), getUser(), getStartDate(), getEndDate());
    }
}
