package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TravelInsuarance extends BasePage{


		public TravelInsuarance(WebDriver driver){
			super(driver);
			
		}	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	
	@FindBy(xpath="//*[@id=\"favourite-country\"]/li[2]/p") 
	WebElement country;
	
	@FindBy(xpath="//*[@class=\"MuiInputBase-input MuiOutlinedInput-input\"]") 
	WebElement dateInput;

	@FindBy(xpath="(//*[@class=\"MuiPickersDay-dayLabel\"][text()=\"1\"])[2]") 
	WebElement startDate;
	
	@FindBy(xpath="(//*[@class=\"MuiPickersDay-dayLabel\"][text()=\"8\"])[2]") 
	WebElement endDate;
	
	@FindBy(xpath="//*[text()=\"Next\"]") 
	WebElement nextButton;
	
	@FindBy(xpath="//*[text()=\"2\"]") 
	WebElement no_OfPeople;
	
	@FindBy(xpath="//div[@id=\"0\"]") 
	WebElement age1SelectBox;
	
	@FindBy(xpath="//label[text()=\"22 years\"]") 
	WebElement age1;
	
	@FindBy(xpath="//div[@id=\"1\"]") 
	WebElement age2SelectBox;
	
	@FindBy(xpath="//label[text()=\"21 years\"]") 
	WebElement age2;
	
	@FindBy(xpath="//input[@id=\"ped_no\"]") 
	WebElement medicalCondition;
	
	@FindBy(xpath="//input[@id=\"mobileNumber\"]") 
	WebElement mobileNumberInput;
	//7575757575
	
	@FindBy(xpath="//button[@class=\"travel_main_cta\"]") 
	WebElement viewPlanButton;
	
	@FindBy(xpath="//a[text()=\"Policybazaar\"]") 
	 WebElement home;
	
	
	
    public void selectCountry() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	js.executeScript("arguments[0].click()",country);
    }

    public void clcikOnNext() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	js.executeScript("arguments[0].click()",nextButton);
    }
    public void selectDate() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	js.executeScript("arguments[0].click()",dateInput);
    	js.executeScript("arguments[0].click()",startDate);
    	js.executeScript("arguments[0].click()",endDate);
    }
    
    public void selectNumberOfMember() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	no_OfPeople.click();
    }
    
    public void selectage1() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	age1SelectBox.click();
    	age1.click();
    	
    }
    public void selectage2() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	age2SelectBox.click();
    	age2.click();
    }
    
    public void medicalCondition() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	medicalCondition.click();
    }
    
    public void enterMobileNumber(String number) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	mobileNumberInput.sendKeys(number);
    }
    
    public void viewPlan() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	js.executeScript("arguments[0].click()",viewPlanButton);

    }
    
   
  


}
