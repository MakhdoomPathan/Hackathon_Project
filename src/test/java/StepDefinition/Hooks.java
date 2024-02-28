package StepDefinition;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.BaseClassCucumber;


public class Hooks {

	public static WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException, TimeoutException
    {
		System.out.println(";;;;;;;;;;;;;kkkkk..............");
    	driver=BaseClassCucumber.initilizeBrowser();  	
    	p=BaseClassCucumber.getProperties();
    	driver.manage().window().maximize();
    	driver.get(p.getProperty("appURL"));
    
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }
   
}
