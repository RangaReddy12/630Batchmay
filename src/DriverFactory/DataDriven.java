package DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelFileUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataDriven {
String inputpath="C:\\6.30Batch\\Selenium_FrameWorks\\TestInput\\Registerdata.xlsx";
String outputpath="C:\\6.30Batch\\Selenium_FrameWorks\\TestOutput\\Results.xlsx";
ExtentReports report;
ExtentTest test;
WebDriver driver;
@BeforeTest
public void setUp()
{
System.setProperty("webdriver.chrome.driver", "C:\\6.30Batch\\Selenium_FrameWorks\\Drivers\\chromedriver.exe");
driver=new ChromeDriver();
report=new ExtentReports("./ExtentReports/DataDriven.html");
}
@Test
public void verifyRegister()throws Throwable
{
//access excel methods
ExcelFileUtil xl=new ExcelFileUtil(inputpath);
//count no of rows
int rc=xl.rowCount("Register");
//count no of columns
int cc=xl.colCount("Register");
Reporter.log("no of rows are::"+rc+"   "+"no of columns are::"+cc,true);
for(int i=1;i<=rc;i++)
{
test=report.startTest("Validate Register");	
	//read all coulms from sheet
driver.get("http://newtours.demoaut.com/");
driver.manage().window().maximize();
String fname=xl.getCellData("Register", i, 0);
String lname=xl.getCellData("Register", i, 1);
String phone=xl.getCellData("Register", i, 2);
String email=xl.getCellData("Register", i, 3);
String address1=xl.getCellData("Register", i, 4);
String address2=xl.getCellData("Register", i, 5);
String city=xl.getCellData("Register", i, 6);
String state=xl.getCellData("Register", i, 7);
String pcode=xl.getCellData("Register", i, 8);
String country=xl.getCellData("Register", i, 9);
String username=xl.getCellData("Register", i, 10);
String password=xl.getCellData("Register", i, 11);
String cpassword=xl.getCellData("Register", i, 12);
//send data to register form
driver.findElement(By.partialLinkText("REG")).click();
Thread.sleep(5000);
driver.findElement(By.name("firstName")).sendKeys(fname);
driver.findElement(By.name("lastName")).sendKeys(lname);
driver.findElement(By.name("phone")).sendKeys(phone);
driver.findElement(By.name("userName")).sendKeys(email);
driver.findElement(By.name("address1")).sendKeys(address1);
driver.findElement(By.name("address2")).sendKeys(address2);
driver.findElement(By.name("city")).sendKeys(city);
driver.findElement(By.name("state")).sendKeys(state);
driver.findElement(By.name("postalCode")).sendKeys(pcode);
new Select(driver.findElement(By.name("country"))).selectByVisibleText(country);
driver.findElement(By.name("email")).sendKeys(username);
driver.findElement(By.name("password")).sendKeys(password);
driver.findElement(By.name("confirmPassword")).sendKeys(cpassword);
driver.findElement(By.name("register")).click();
if(password.equals(cpassword))
{
	//get message
String message=driver.findElement(By.xpath("//font[contains(text(),'Thank you for registering.')]")).getText();
Reporter.log(message,true);
//write into results column
xl.setCellData("Register", i, 13, message, outputpath);
//write pass into status column
xl.setCellData("Register", i, 14, "Pass", outputpath);
test.log(LogStatus.PASS, message);
}
else
{
Reporter.log("Password and cpassword is not eqaul",true);
//write into results column
xl.setCellData("Register", i, 13, "Password and cpassword is not eqaul", outputpath);
//write pass into status column
xl.setCellData("Register", i, 14, "Fail", outputpath);
test.log(LogStatus.FAIL, "Password and cpassword is not eqaul");
}
report.endTest(test);
report.flush();
}
}
@AfterTest
public void tearDown()
{
	driver.close();
}
}









