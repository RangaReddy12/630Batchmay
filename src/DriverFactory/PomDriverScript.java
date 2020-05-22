package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelFileUtil;
import ApplicationLayer.AddEmpPage;
import ApplicationLayer.LoginPage;
import ApplicationLayer.LogoutPage;

public class PomDriverScript {
String inputpath="C:\\6.30Batch\\Selenium_FrameWorks\\TestInput\\empdata.xlsx";
String outputpath="C:\\6.30Batch\\Selenium_FrameWorks\\TestOutput\\Resultemp.xlsx";
WebDriver driver;
@BeforeTest
public void setUp()throws Throwable
{
	driver=new ChromeDriver();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
LoginPage login=PageFactory.initElements(driver, LoginPage.class);
login.verifyLogin("Admin", "Qedge123!@#");
}
@Test
public void addemp()throws Throwable
{
	AddEmpPage emp=PageFactory.initElements(driver, AddEmpPage.class);
	ExcelFileUtil xl=new ExcelFileUtil(inputpath);
	//count no of rows in emp sheet
	int rc=xl.rowCount("emp");
	Reporter.log("no of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
	String fname=xl.getCellData("emp", i, 0);
	String lname=xl.getCellData("emp", i, 1);
	String eid=xl.getCellData("emp", i, 2);
	String empres=emp.verifyAddemp(fname, lname, eid);
	xl.setCellData("emp", i, 3, empres, outputpath);
	}
}
@AfterTest
public void teardown()throws Throwable
{
LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
logout.verifylogout();
driver.close();
}
}












