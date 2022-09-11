package model;


import java.time.LocalDate;
import java.util.UUID;
@AllArgsConstructor
@ToString
public class Book {
    @Getter @Setter
    private UUID uuid;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String authorName;
    @Getter @Setter
    private LocalDate releaseDate;
    @Getter @Setter
    private boolean archived = false;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lane)) return false;
        Book book = (Book) o;
        return Objects.equals(getUuid(), book.getUuid()) && getType() == book.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getTitle());
    }
}
