package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
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
