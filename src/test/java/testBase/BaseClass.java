package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeTest
	public void setup() {
		
		//logger = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.urbanladder.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
