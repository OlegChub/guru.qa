package helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
    // игнорировать неиспользуемые поля json
@JsonIgnoreProperties(ignoreUnknown = true)
/*
Данный класс для схемы типа
{
  "isbn": "9781449325862",
  "title": "Git Pocket Guide",
  "subTitle": "A Working Introduction",
  "author": "Richard E. Silverman"
}
 */
public class LombokBook {
    // указываем поля, которые будем проверять в json ответе. Lombok сам создает getters/setters
    private String isbn;
    private String title;
    private String author;
    @JsonProperty("publish_date")
    private String publishDate;
    private Integer pages;
}
