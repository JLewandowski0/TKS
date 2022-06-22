package appcontroller.modelDto;



import java.util.UUID;

public class RentEntityDto {


    private String startDate;

    private UUID clientUuid;

    private UUID bookUuid;

    public RentEntityDto(String startDate,UUID clientUuid, UUID bookUuid) {
        this.startDate = startDate;
        this.clientUuid = clientUuid;
        this.bookUuid = bookUuid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public UUID getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(UUID clientUuid) {
        this.clientUuid = clientUuid;
    }

    public UUID getBookUuid() {
        return bookUuid;
    }

    public void setBookUuid(UUID bookUuid) {
        this.bookUuid = bookUuid;
    }
}
