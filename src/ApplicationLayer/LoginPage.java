package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
WebDriver driver;
Actions ac;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
}
//maintain Repository for login
@FindBy(name="txtUsername")
WebElement username;
@FindBy(xpath="//input[@id='txtPassword']")
WebElement password;
@FindBy(name="Submit")
WebElement login;
public String verifyLogin(String username,String password)throws Throwable
{
	ac=new Actions(driver);
	String res=null;
	this.username.sendKeys(username);
	this.password.sendKeys(password);
	ac.moveToElement(login).click().perform();
	Thread.sleep(5000);
	String expected="dash";
	String actual=driver.getCurrentUrl();
	if(actual.contains(expected))
	{
		res="Login success";
	}
	else
	{
		res="Login Fail";
	}
	return res;
}
}
