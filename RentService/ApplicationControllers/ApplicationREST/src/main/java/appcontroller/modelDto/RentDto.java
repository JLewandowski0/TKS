package appcontroller.modelDto;




import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
public class RentDto {

        private UUID uuid;
        private LocalDate startDate;
        private LocalDate endDate = null;
        private UserDto user;
        private BookDto book;

}
