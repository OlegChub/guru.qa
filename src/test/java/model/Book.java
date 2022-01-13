package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    public String isbn;
    public String title;
    public String subTitle;
    public String author;
    @JsonProperty("publish_date")
    public Date publishDate;
    public String publisher;
    public int pages;
    public String description;
    public String website;
}
