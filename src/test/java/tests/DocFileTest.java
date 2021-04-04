package tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;

public class DocFileTest {
    @Test
    void docxTest() throws IOException, InvalidFormatException {
        String docxFilePath = "./src/test/resources/files/1.docx";
        String expectedData = "hello qa.guru students!";
        String actualData = getDocx(docxFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void docTest() throws IOException, InvalidFormatException {
        String docFilePath = "./src/test/resources/files/1.doc";
        String expectedData = "hello qa.guru students!";
        String actualData = getDoc(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
