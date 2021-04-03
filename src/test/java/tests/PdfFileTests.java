package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;


public class PdfFileTests {

        @Test
        void pdfTest() throws IOException {
            String pdfFilePath = "./src/test/resources/files/1.pdf";
            String expectedData = "Selenide Advent Calendar";

            PDF pdf = getPdf(pdfFilePath);
            assertThat(pdf, PDF.containsText(expectedData));




        }
}
