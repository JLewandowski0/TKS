package appcontroller.modelDto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BookDto implements Serializable {

    private String uuid;
    private String title;
    private String authorName;
    private String releaseDate;


    public BookDto(@JsonProperty("title") String title,
                   @JsonProperty("authorName") String authorName,
                   @JsonProperty("releaseDate") String releaseDate) {
        this.title = title;
        this.authorName = authorName;
        this.releaseDate = releaseDate;

    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }




    @Override
    public String toString() {
        return "Book{" +
                "id='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
