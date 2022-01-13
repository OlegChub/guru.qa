package specs;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

//выносим часто используемые настройки запроса в отдельную спеку и далее добавляем метод в given()/body или через .spec
public class RestAssuredSpec {
    static public RequestSpecification requestSpecification =
            with()
                    .baseUri("https://demoqa.com")
                    .contentType(ContentType.JSON)
                    .filter(customLogFilter().withCustomTemplates())
                    .log().all();

    static public ResponseSpecification resSpec = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .build();
}
