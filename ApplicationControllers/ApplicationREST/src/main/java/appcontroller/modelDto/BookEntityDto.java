package appcontroller.modelDto;




public class BookEntityDto {

    private String title;

    private String authorName;

    private String releaseDate;


    public BookEntityDto(String title, String authorName, String releaseDate) {
        this.title = title;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
