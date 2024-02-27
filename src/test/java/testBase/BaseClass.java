package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public static Properties p;
	
	@BeforeTest(groups= {"regression","master","sanity"})
	public void setup() throws IOException {
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		String nodeURL= "http://localhost:4444/wd/hub";
		
		//logger = LogManager.getLogger(this.getClass());
		if(p.getProperty("environment").equalsIgnoreCase("local")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.urbanladder.com/");
		}else {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WIN11);
			cap.setBrowserName("chrome");
			//MicrosoftEdge
			driver = new RemoteWebDriver(new URL(nodeURL),cap);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.urbanladder.com/");
		}
		
	}
	
	@AfterTest(groups= {"regression","master","sanity"})
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		
		TakesScreenshot tS = (TakesScreenshot)driver;
		File sourceFile = tS.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
}
