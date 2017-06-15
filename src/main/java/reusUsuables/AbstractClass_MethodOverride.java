package reusUsuables;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import reusUsuables.reusuableMethods;

import java.io.IOException;

/**
 * Created by Mizan on 6/4/2017.
 */
public class AbstractClass_MethodOverride {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest  test;
    public static String reportpath = null;



    @BeforeSuite
    public static void openBrowser() throws IOException, InterruptedException {
        reportpath = "C:\\Users\\Mizan\\Documents\\Report\\newReport.html";
        reports = new ExtentReports(reportpath, true);
        driver = reusuableMethods.wDriver();
        Thread.sleep(3000);


    }

    @AfterSuite
    public static void closeBroser(){
        //to end extent test you need to call the command below
        reports.endTest(test);

       //Flush the report
        reports.flush();

        //line below will open the report
        driver.get( reportpath );

        //Close the report
        //reports.close();
    }



}
