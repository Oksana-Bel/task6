package tests;


import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.getXls;
import static utils.Files.readXlsxFromPath;


public class XlsFileTests {
    @Test
    void xlsTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/11.xls";
        String expectedData = "some text here";


        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));

    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/11.xls";
        String expectedData = "some text here";

        XLS xls = new XLS(new File(xlsFilePath));
        String actualData = xls.excel.getSheetAt(0).getRow(1).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));

    }

    @Test
    void xlsxTest(){
        String xlsFilePath = "./src/test/resources/files/12.xlsx";
        String expectedData = "some text here";

        String actualData = readXlsxFromPath(xlsFilePath);
                assertThat(actualData, containsString(expectedData));
    }
}
