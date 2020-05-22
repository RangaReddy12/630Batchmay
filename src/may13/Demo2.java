package may13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver driver;
	@Test
	public void login()
	{
		driver=new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		//create object for webdriverwait class
		WebDriverWait wait=new WebDriverWait(driver, 300);
		//wait until username text box visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtuId")));
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		//wait until password text box visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtPword")));
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		//wait until login is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
		driver.findElement(By.name("login")).click();
		
	WebElement branches=driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]"));
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")));
branches.click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")));
	driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")).click();
	}
}
