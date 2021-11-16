package homework.lesson6;

import com.codeborne.pdftest.PDF;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WorkWithFiles {

    @DisplayName("Download pdf file")
    @Test
    public void downloadAndCheckPDFfile() throws IOException {
        open("https://zagorie.ru/sanatory/sale/");
        File download = $("[target='_blank']").download();
        PDF parsedPDF = new PDF(download);
        int pagesCount = 3;
        String title = "Заявление о возврате суммы излишне уплаченного";

        assertEquals(pagesCount, parsedPDF.numberOfPages);
        assertThat(parsedPDF, containsText(title));
    }

    @DisplayName("Download xls file")
    @Test
    public void downloadAndCheckExcelFile() throws IOException {
        open("https://ckmt.ru/price-download.html");
        File file = $("h3 a").download();
        XLS parseXLS = new XLS(file);
        String stringExpected = "Техресурс";
        boolean cellValue = parseXLS.excel
                .getSheetAt(0)
                .getRow(0)
                .getCell(3)
                .getStringCellValue()
                .contains(stringExpected);
        assertTrue(cellValue);
    }
}
