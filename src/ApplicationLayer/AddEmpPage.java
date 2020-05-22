package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmpPage {
WebDriver driver;
Actions ac;
public AddEmpPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath="//b[contains(text(),'PIM')]")
WebElement clickpim;
@FindBy(name="btnAdd")
WebElement clickAdd;
@FindBy(name="firstName")
WebElement enterfname;
@FindBy(name="lastName")
WebElement enterlname;
@FindBy(id="employeeId")
WebElement entereid;
@FindBy(id="btnSave")
WebElement clicksave;
public String verifyAddemp(String fname,String lname,String eid)throws Throwable
{
	String res=null;
	ac=new Actions(driver);
	ac.moveToElement(clickpim).click().perform();
	Thread.sleep(5000);
	ac.moveToElement(clickAdd).click().perform();
	Thread.sleep(5000);
	this.enterfname.sendKeys(fname);
	this.enterlname.sendKeys(lname);
	this.entereid.clear();
	this.entereid.sendKeys(eid);
	ac.moveToElement(clicksave).click().perform();
	Thread.sleep(5000);
	String expected="empNumber";
	String actual=driver.getCurrentUrl();
	if(actual.contains(expected))
	{
		res="Pass";
	}
	else
	{
		res="Fail";
	}
	return res;
}

}
