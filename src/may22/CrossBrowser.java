package may22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;
	String url="http://calculator.net";
@Parameters({"browser"})
@BeforeTest
public void setUp(String brw)
{
	if(brw.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\6.30Batch\\Selenium_FrameWorks\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	else if(brw.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\6.30Batch\\Selenium_FrameWorks\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(url);
		}
	else
	{
		System.out.println("Browser is not matching");
	}
}
@Test
public void validatecal()throws Throwable
{
driver.findElement(By.partialLinkText("Math Calculato")).click();
Thread.sleep(5000);
driver.findElement(By.partialLinkText("Percentage Calculat")).click();
Thread.sleep(5000);
driver.findElement(By.name("cpar1")).sendKeys("10");
Thread.sleep(5000);
driver.findElement(By.name("cpar2")).sendKeys("20000");
Thread.sleep(5000);
driver.findElement(By.xpath("//table[1]//tbody[1]//tr[2]//td[1]//input[2]")).click();
Thread.sleep(5000);
//get message
String result=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/p[2]/font[1]/b[1]")).getText();
if(result.equals("2000"))
{
	System.out.println("Calculation is Correct::"+result);
}
else
{
	System.out.println("Calculation is InCorrect::"+result);
}
}
@AfterTest
public void teardown()
{
	driver.close();
	
}
}







