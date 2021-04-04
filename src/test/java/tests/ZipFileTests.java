package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;
import utils.Files;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTests {
    @Test
    void zipWithPasswordTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/1.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/1.txt";
        String expectedData = "hello qa.guru students!";

            unzip(zipFilePath, unzipFolderPath, zipPassword);
            String actualData = readTextFromPath(unzipTxtFilePath);
            assertThat(actualData, containsString(expectedData));
            Files.deleteFile(unzipFolderPath);                              //clean the ./src/test/resources/files/unzip folder after job done
    }

    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/1.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/1.txt";
        String expectedData = "hello qa.guru students!";

            unzip(zipFilePath, unzipFolderPath);
            String actualData = readTextFromPath(unzipTxtFilePath);
            assertThat(actualData, containsString(expectedData));
            Files.deleteFile(unzipFolderPath);                              //clean the ./src/test/resources/files/unzip folder after job done
    }
}
