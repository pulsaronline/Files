package tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getDoc;
import static utils.Files.readXlsxFromPath;

public class DocFileTest {
    @Test
    void docTest() throws IOException, InvalidFormatException {
        String docFilePath = "./src/test/resources/files/1.docx";
        String expectedData = "hello qa.guru students!";
        String actualData = getDoc(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
