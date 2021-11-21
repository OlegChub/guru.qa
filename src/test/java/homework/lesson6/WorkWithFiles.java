package homework.lesson6;

import com.codeborne.pdftest.PDF;

import com.codeborne.xlstest.XLS;
import homework.TestBaseWithListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static com.codeborne.pdftest.PDF.containsText;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Download and check downloaded files")
public class WorkWithFiles extends TestBaseWithListener {

    @DisplayName("Download pdf file")
    @Test
    public void downloadAndCheckPDFfile() throws IOException {
        int pagesCount = 3;
        String title = "Заявление о возврате суммы излишне уплаченного";

        open("https://zagorie.ru/sanatory/sale/");
        File download = $("[target='_blank']").download();
        PDF parsedPDF = new PDF(download);

        assertEquals(pagesCount, parsedPDF.numberOfPages);
        assertThat(parsedPDF, containsText(title));
    }

    @DisplayName("Download xls file")
    @Test
    public void downloadAndCheckExcelFile() throws IOException {
        String stringExpected = "Техресурс";

        open("https://ckmt.ru/price-download.html");
        File file = $("a[href*='.xls']").download();
        XLS parseXLS = new XLS(file);

        boolean cellValue = parseXLS.excel
                .getSheetAt(0)
                .getRow(0)
                .getCell(3)
                .getStringCellValue()
                .contains(stringExpected);
        assertTrue(cellValue);
    }

    @DisplayName("Download zip file")
    @Test
    public void downloadAndCheckZipFile() throws IOException {
        String expectedFileName="ksanf.xls";
        int expectedFilesCount=1;

        open("http://ksanf.spb.ru/prise.html");
        File file = $("a[href*='.zip']").download();
        ZipFile zipFile = new ZipFile(file);

        Enumeration<?> entries = zipFile.entries();
        ArrayList<ZipEntry> listWithEntries = new ArrayList<>();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = ((ZipEntry) entries.nextElement());
            listWithEntries.add(zipEntry);
        }
        assertEquals(expectedFilesCount, listWithEntries.size());
        assertEquals(expectedFileName, listWithEntries.get(0).toString());
    }
}
