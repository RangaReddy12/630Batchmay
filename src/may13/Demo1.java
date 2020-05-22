package may13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver driver;
@Test
public void login()
{
	driver=new FirefoxDriver();
	driver.get("http://primusbank.qedgetech.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(By.name("txtuId")).sendKeys("Admin");
	driver.findElement(By.name("txtPword")).sendKeys("Admin");
	driver.findElement(By.name("login")).click();
	driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
	driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")).click();
}
}
