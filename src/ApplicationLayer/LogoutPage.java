package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
WebDriver driver;
Actions ac;
public LogoutPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(id="welcome")
WebElement  clickwelcome;
@FindBy(xpath="//a[contains(text(),'Logout')]")
WebElement clicklogout;
public void verifylogout()throws Throwable
{
	ac=new Actions(driver);
	ac.moveToElement(clickwelcome).click().perform();
	Thread.sleep(5000);
	ac.moveToElement(clicklogout).click().perform();
	Thread.sleep(5000);
	
}
}
