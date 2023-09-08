package pageObject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import org.junit.internal.runners.statements.Fail;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ExtentReportsTest {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        extentReports.attachReporter(sparkReporter);

//        ExtentTest test1 = extentReports.createTest("Test 1");
//        test1.pass("This is passed");

//        ExtentTest test2 = extentReports.createTest("Test 2");
//        test2.log(Status.FAIL, "This is failed");
//
//        extentReports.createTest("Test 3").skip("This is skipped");


        //Log level in extent reports
//        extentReports
//                .createTest("Test 1")
//                .log(Status.INFO, "info1")
//                .log(Status.INFO, "info2")
//                .log(Status.INFO, "info2")
//                .log(Status.PASS, "pass")
//                .log(Status.WARNING, "warning")
//                .log(Status.WARNING, "warning")
//                .log(Status.SKIP, "skip")
//                .log(Status.FAIL, "fail1")
//                .log(Status.FAIL, "fail2");

        //Log different type of information to the extent reports
        extentReports
                .createTest("Text based Test")
                .log(Status.INFO, "info1")
                .log(Status.INFO, "<b>info2</b>")
                .log(Status.INFO, "<i>info2</i>");

        String xmlData = "<menu id=\"file\" value=\"File\">\n" +
                "  <popup>\n" +
                "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                "  </popup>\n" +
                "</menu>";

        String jsonData = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";

        extentReports
                .createTest("XML based Test")
                .info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));

        extentReports
                .createTest("JSON based Test")
                .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

        List<String> listData = new ArrayList<>();
        listData.add("Yadagiri");
        listData.add("Jeevan");
        listData.add("Raj");

        Map<Integer, String> mapData = new HashMap<>();
        mapData.put(101, "Yadagiri");
        mapData.put(102, "Jeevan");
        mapData.put(103, "Raj");

        Set<Integer> setData = mapData.keySet();

        extentReports
                .createTest("List based Test")
                .info(MarkupHelper.createOrderedList(listData))
                .info(MarkupHelper.createUnorderedList(listData));

        extentReports
                .createTest("Set based Test")
                .info(MarkupHelper.createOrderedList(setData))
                .info(MarkupHelper.createUnorderedList(setData));

        extentReports
                .createTest("Set based Test")
                .info(MarkupHelper.createOrderedList(mapData))
                .info(MarkupHelper.createUnorderedList(mapData));


        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }
}
