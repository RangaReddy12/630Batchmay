package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ApplicationLayer.AddEmpPage;
import ApplicationLayer.AddUserPage;
import ApplicationLayer.LoginPage;
import ApplicationLayer.LogoutPage;

public class TestScript {
WebDriver driver;
@BeforeMethod
public void setup()throws Throwable
{
	driver=new ChromeDriver();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	//access login page
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	//call login method
String loginresults=login.verifyLogin("Admin", "Qedge123!@#");
Reporter.log(loginresults,true);
}
@Test(description="Validate add user",priority=0,enabled=false)
public void adduser()throws Throwable
{
AddUserPage user=PageFactory.initElements(driver, AddUserPage.class);
String userresult=user.verifyAddUser("Bala srikanth", "Akhilesh234", "Akhilesh@12345690", "Akhilesh@12345690");
Reporter.log(userresult,true);
}
@Test(description="Validate add emp",priority=1,enabled=true)
public void addemp()throws Throwable
{
	AddEmpPage emp=PageFactory.initElements(driver, AddEmpPage.class);	
	String empres=emp.verifyAddemp("Rita", "Meta","39090");
	Reporter.log(empres,true);
}
@AfterMethod
public void teardown()throws Throwable
{
	LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
	logout.verifylogout();
	driver.close();
}
}















