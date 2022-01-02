package filters;

import io.qameta.allure.restassured.AllureRestAssured;

//делает разноцветным аллюр отчет
public class CustomLogFilter {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private CustomLogFilter() {
    }

    public static CustomLogFilter customLogFilter() {
        return InitLogFilter.logFilter;
    }

    //ftl-файлы должны храниться в resources/tpl
    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;

    }

    private static class InitLogFilter {
        private static final CustomLogFilter logFilter = new CustomLogFilter();
    }
}
