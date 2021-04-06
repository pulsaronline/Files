package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

// DOC: https://selenide.org/2019/12/10/advent-calendar-download-files/
public class DownloadTest {

    private String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    @Test
    void downloadTest() throws IOException {
        Configuration.downloadsFolder = "./downloads";

        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadedFile);
        assertThat(fileContent, containsString("Selenide = UI Testing Framework powered by Selenium WebDriver"));
    }

    @Test
    @Disabled
    void downloadTest1(){
        open("https://github.com/selenide/selenide/blob/master/README.md");
        try {
            $("#raw-url").download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
