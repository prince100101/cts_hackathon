package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties p;
	
	@Parameters({"browser"})
	@BeforeTest(groups= {"regression","master","sanity"})
	public void setup(String br) throws IOException {
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		String nodeURL= "http://localhost:4444/wd/hub";
				
		if(p.getProperty("environment").equalsIgnoreCase("local")) {
			if(br.equals("chrome")) {
				driver = new ChromeDriver();
			}else if(br.equals("edge")) {
				driver = new EdgeDriver();
			}else {
				System.out.println("Browser not available");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.urbanladder.com/");
		}else {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WIN11);
			if(br.equals("chrome")) {
				cap.setBrowserName("chrome");
			}else {
				cap.setBrowserName("MicrosoftEdge");
			}
			driver = new RemoteWebDriver(new URL(nodeURL),cap);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("url"));
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
