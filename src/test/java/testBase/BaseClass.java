package testBase;

import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.CarInsuarance;
import pageObjects.HealthInsuarance;
import pageObjects.HomePage;
import pageObjects.TravelInsuarance;
import pageObjects.Travel_Insuarance_Plan;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BaseClass {

	public  static WebDriver driver;
	public static HomePage home;
	public static TravelInsuarance te;
	public static CarInsuarance cr;
	public static Travel_Insuarance_Plan plan;
	public static HealthInsuarance he;
	
	public static Logger logger;
	public static Properties prop;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browser) throws IOException 
	{
        logger=LogManager.getLogger();
		
		prop = new Properties();
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		prop.load(file);
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if (prop.getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (prop.getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (prop.getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		
		System.out.println("assigned");
		if (browser.equals("chrome")) {
			ChromeOptions ch=new ChromeOptions();
			ch.addArguments("--disable-notifications");
			ch.addArguments("--disable-blink-features=AutomationControlled");
			driver=new ChromeDriver(ch);
			logger.info("**********Chrome is initialized ********");
		}
		else if(browser.equals("edge")) {
			EdgeOptions ed=new EdgeOptions();
			ed.addArguments("--disable-notifications");
			ed.addArguments("--disable-blink-features=AutomationControlled");
			driver=new EdgeDriver(ed);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("appURL"));
		 }
		}
	
	
	
	public  String captureScreen(String tname)throws IOException{
			
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
			File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\ER_screenshots\\" + tname +"-" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}
	
	public void takeScreenshot(WebDriver driver,String photoName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\screenshots\\"+photoName+".png");
		FileUtils.copyFile(src, trg);
	}
	
	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
