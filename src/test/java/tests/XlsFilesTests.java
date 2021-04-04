package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getXls;
import static utils.Files.readXlsxFromPath;

public class XlsFilesTests {
    @Test
    void xlsTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "hello qa.guru students!";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "hello qa.guru students!";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(0).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));
    }
    @Test
    void xlsxTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "hello qa.guru students!";
        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
