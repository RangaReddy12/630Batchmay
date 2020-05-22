package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {
WebDriver driver;
Actions ac;
public AddUserPage(WebDriver driver)
{
	this.driver=driver;
}
//Maintain OR For Add user
@FindBy(xpath="//b[contains(text(),'Admin')]")
WebElement clickadmin;
@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
WebElement clickusermngnt;
@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")
WebElement clickuser;
@FindBy(id="btnAdd")
WebElement clickadd;
@FindBy(name="systemUser[employeeName][empName]")
WebElement enterename;
@FindBy(name="systemUser[userName]")
WebElement enterusername;
@FindBy(name="systemUser[password]")
WebElement enterpassword;
@FindBy(name="systemUser[confirmPassword]")
WebElement entercpassword;
@FindBy(name="btnSave")
WebElement clicksave;
public String verifyAddUser(String ename,String username,String password,String cpassword)
throws Throwable{
	String res=null;
ac=new Actions(driver);
ac.moveToElement(clickadmin).perform();
Thread.sleep(4000);
ac.moveToElement(clickusermngnt).perform();
Thread.sleep(4000);
ac.moveToElement(clickuser).click().perform();
Thread.sleep(4000);
ac.moveToElement(clickadd).click().perform();
Thread.sleep(4000);
this.enterename.sendKeys(ename);
this.enterusername.sendKeys(username);
this.enterpassword.sendKeys(password);
this.entercpassword.sendKeys(cpassword);
this.clicksave.click();
Thread.sleep(5000);
String expected="viewSystemUsers";
String actual=driver.getCurrentUrl();
if(actual.contains(expected))
{
	res="pass";
}
else
{
	res="fail";
}
return res;
}
}










