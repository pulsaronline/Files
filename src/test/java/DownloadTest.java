import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DownloadTest {
    @Test
    void downloadTest() throws FileNotFoundException {
        Configuration.downloadsFolder = "./downloads";

        open("https://github.com/selenide/selenide/blob/master/README.md");
        File dowloadedFile = $("#raw-url").download();
        File dowloaded1File = $("#raw-url").download();

// Selenide = UI Testing Framework powered by Selenium WebDriver
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
