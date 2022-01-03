package specs;


import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

//выносим часто используемые настройки запроса в отдельную спеку и далее добавляем метод в given() или через .spec
public class RestAssuredSpec {
    static public RequestSpecification requestSpecification =
            with()
                    .baseUri("https://demoqa.com")
                    .contentType(ContentType.JSON)
                    .filter(customLogFilter().withCustomTemplates())
                    .log().all();
}
