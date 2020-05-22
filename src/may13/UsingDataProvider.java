package may13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UsingDataProvider {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	  public void beforeTest() {
	System.setProperty("webdriver.chrome.driver", "C:\\6.30Batch\\Selenium_FrameWorks\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	report=new ExtentReports("./Reports/dataprovider.html");
	  }
  @Test(dataProvider = "supplydata")
  public void verifyLogin(String username,String password) 
  {
	  test=report.startTest("Validate login");
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.name("txtUsername")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	if(driver.getCurrentUrl().contains("dash"))
	{
		Reporter.log("Login success",true);
		test.log(LogStatus.PASS, "Pass");
	}
	else
	{
	Reporter.log("Login Fail",true);
	test.log(LogStatus.FAIL, "Fail");
  }
  }
  @DataProvider
  public Object[][] supplydata() {
    Object login[][]={{"Admin","Qedge123!@#"},
    		{"Test","Qedge123!@#"},
    		{"Admin"," "},
    		{"Admin","Qedge123!@#"}};
    return login;
  }
    @AfterTest
  public void afterTest() 
    {
    	report.endTest(test);
    	report.flush();
    	driver.close();
  }

}
