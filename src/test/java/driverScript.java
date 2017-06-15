import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import reusUsuables.AbstractClass_MethodOverride;
import reusUsuables.reusuableMethods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mizan on 6/10/2017.
 */
public class driverScript extends AbstractClass_MethodOverride {

    @Test
    public void testCsase1(){

        test = reports.startTest("Axial Log In", "Log In Test");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        try{
            test.log(LogStatus.INFO, "Navigating to Axial Log In Page");
            driver.navigate().to("https://yellow.axialmarket.com");
            test.log(LogStatus.PASS, "Page Open Successfully : URL Test Passed!");
        }catch (Exception e) {
            test.log(LogStatus.FAIL,"URL Not Found");
            System.out.println("URL not found "+ e.getMessage() );
        }


    }

    @Test(dependsOnMethods = "testCsase1" )

    public void testCase2()  {

        test = reports.startTest("Email Field Test", "Validating email field");

        try{
            test.log(LogStatus.INFO,"Inserting email id into email field");
            driver.findElement(By.name("email")).sendKeys("test@test.test");
            test.log(LogStatus.PASS, "email field found and updated email id successfully : Email Field Test Pass!");
        }catch (Exception e){
            test.log(LogStatus.FAIL, "email field not found");
            System.out.println("email field not found" + e.getMessage());
        }


        }


    @Test(dependsOnMethods = "testCase2")
    public  void testCase3(){

        test = reports.startTest("Password Field Test", "Validating Password field");

        try{
            test.log(LogStatus.INFO, "inserting password into password field");
            driver.findElement(By.name("pword")).sendKeys("Qualitest1");
            test.log(LogStatus.PASS, "Password field found and password inserted successfully: Password Field Test Pass!");
        }catch (Exception e){
            test.log(LogStatus.FAIL, "Password field not found" +e.getMessage());
            System.out.println("Password field not found"+ e.getMessage());
        }


        }

    @Test (dependsOnMethods = "testCase3")
    public void testCase4(){

        test = reports.startTest("SIGN IN button Test", "Validating SIGN IN button");

        try{
            test.log(LogStatus.INFO,"Clicking on SIGN IN button");
            driver.findElement(By.name("SignInForm")).click();
            test.log(LogStatus.PASS, "Clicked on SIGN IN button : Sign In Button Test Pass!");
        }catch (Exception e){
            test.log(LogStatus.FAIL, "SIGN IN button not found"+e.getMessage());
        }



    }
}
