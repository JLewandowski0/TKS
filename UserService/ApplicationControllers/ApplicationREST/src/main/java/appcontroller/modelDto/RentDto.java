package appcontroller.modelDto;




import java.time.LocalDate;
import java.util.UUID;

public class RentDto {

        private UUID uuid;
        private LocalDate startDate;
        private LocalDate endDate = null;
        private UserDto client;
        private BookDto book;

        public RentDto(LocalDate startDate, UserDto client, BookDto book) {
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

        public UserDto getClient() {
            return client;
        }

        public BookDto getBook() {
            return book;
        }

        public UUID getUuid() {
            return uuid;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
