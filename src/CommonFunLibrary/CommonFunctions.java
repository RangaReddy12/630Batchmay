package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Constant.PBConstant;

public class CommonFunctions extends PBConstant {
/*Project Name:Primus Bank
 * Module Name: Admin login
 * Tester Name:Ranga
 * Creation Date:06-05-2020
 */
public static boolean verifyLogin(String username,String password)throws Throwable
{
driver.findElement(By.xpath(p.getProperty("enterusername"))).sendKeys(username);	
driver.findElement(By.xpath(p.getProperty("enterpassword"))).sendKeys(password);	
driver.findElement(By.xpath(p.getProperty("login"))).click();
Thread.sleep(5000);
String expval="adminflow";
String actval=driver.getCurrentUrl();
if(actval.toLowerCase().contains(expval.toLowerCase()))
{
	Reporter.log("Login success",true);
	return true;
}
else
{
	Reporter.log("Login Fail",true);
	return false;
}
}
/*Project Name:Primus Bank
 * Module Name: Admin logout
 * Tester Name:Ranga
 * Creation Date:06-05-2020
 */
public static boolean verifyLogout()throws Throwable
{
driver.findElement(By.xpath(p.getProperty("clicklogout"))).click();
Thread.sleep(5000);
if(driver.findElement(By.xpath(p.getProperty("login"))).isDisplayed())
{
	Reporter.log("Logout Success",true);
	return true;
}
else
{
	Reporter.log("Logout Fail",true);
	return false;
}
}
/*Project Name:Primus Bank
 * Module Name: Click branches
 * Tester Name:Ranga
 * Creation Date:06-05-2020
 */
public static void navigateBranches()throws Throwable
{
	driver.findElement(By.xpath(p.getProperty("clickbranches"))).click();
	Thread.sleep(5000);
}
/*Project Name:Primus Bank
 * Module Name: New Branch Creation
 * Tester Name:Ranga
 * Creation Date:06-05-2020
 */
public static boolean verifyBranch(String bname,String address1,String address2,
		String address3,String area,String zcode,int country,int state,int city)
throws Throwable{
driver.findElement(By.xpath(p.getProperty("clicknewbranch"))).click();
Thread.sleep(5000);
driver.findElement(By.xpath(p.getProperty("enterbanme"))).sendKeys(bname);
driver.findElement(By.xpath(p.getProperty("enteradd1"))).sendKeys(address1);
driver.findElement(By.xpath(p.getProperty("enteradd2"))).sendKeys(address2);
driver.findElement(By.xpath(p.getProperty("enteradd3"))).sendKeys(address3);
driver.findElement(By.xpath(p.getProperty("enterarea"))).sendKeys(area);
driver.findElement(By.xpath(p.getProperty("enterzcode"))).sendKeys(zcode);
new Select(driver.findElement(By.xpath(p.getProperty("selectcountry")))).selectByIndex(country);
Thread.sleep(5000);
new Select(driver.findElement(By.xpath(p.getProperty("selectstate")))).selectByIndex(state);
Thread.sleep(5000);
new Select(driver.findElement(By.xpath(p.getProperty("selectcity")))).selectByIndex(city);
Thread.sleep(5000);
driver.findElement(By.xpath(p.getProperty("clicksubmit"))).click();
Thread.sleep(5000);
//get alert message
String alertmessage=driver.switchTo().alert().getText();
Reporter.log(alertmessage);
Thread.sleep(5000);
driver.switchTo().alert().accept();
String exptext="New Branch";
if(alertmessage.toLowerCase().contains(exptext.toLowerCase()))
{
	Reporter.log("Branch created success",true);
	return true;
}
else
{
	Reporter.log("Branch Created Fail",true);
	return false;
}
}
/*Project Name:Primus Bank
 * Module Name: Branch Updation
 * Tester Name:Ranga
 * Creation Date:06-05-2020
 */
public static boolean verifyupdatebranch(String bname,String address1)throws Throwable
{
	driver.findElement(By.xpath(p.getProperty("clickedit"))).click();
	Thread.sleep(5000);
	WebElement branchname=driver.findElement(By.xpath(p.getProperty("updatebname")));
	branchname.clear();
	branchname.sendKeys(bname);
	WebElement address=driver.findElement(By.xpath(p.getProperty("updateadd1")));
	address.clear();
	address.sendKeys(address1);
	driver.findElement(By.xpath(p.getProperty("clickupdate"))).click();
	Thread.sleep(5000);
	String alerttext=driver.switchTo().alert().getText();
	Reporter.log("Branch updated succes",true);
	Thread.sleep(5000);
	driver.switchTo().alert().accept();
	String exptext="Branch updated ";
	if(alerttext.toLowerCase().contains(exptext.toLowerCase()))
	{
		Reporter.log("Branch updated",true);
		return true;
	}
	else
	{
		Reporter.log("Branch updated Fail",true);
		return false;
	}
}
public void login()
{
	
}
}












