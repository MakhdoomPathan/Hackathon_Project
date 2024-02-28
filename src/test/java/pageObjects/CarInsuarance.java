package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CarInsuarance extends BasePage{


		public CarInsuarance(WebDriver driver){
			super(driver);
			
		}	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	
	@FindBy(xpath="//a[@class=\"btn-proceed\"]") 
	WebElement buyNewCar;
	
	@FindBy(xpath="//input[@id=\"regNoTextBox\"]") 
	WebElement inputOfOldCar;
	
	@FindBy(xpath="//button[@id=\"btnGetQuotes\"]") 
	WebElement viewPlan;
	
	@FindBy(xpath="//div[@class=\"fla-data-found \"]/b") 
	WebElement carName;
	
	@FindBy(xpath="//span[@id=\"spn4\"]") 
	WebElement city;

	@FindBy(xpath="//span[text()=\"MH12\"]") 
	WebElement cityNumber;
	
	@FindBy(xpath="//span[@class=\"mg\"]") 
	WebElement carCompany;
	
	@FindBy(xpath="//b[text()=\"Hector\"]") 
	WebElement carModal;
	
	@FindBy(xpath="//b[text()=\"Diesel\"]") 
	WebElement fuelType;
	
	@FindBy(xpath="//li[@class=\"col-sm-6 col-xs-12\"]") 
	WebElement carVariant;
	
	@FindBy(xpath="//input[@id=\"name\"]") 
	WebElement nameInput;
	
	@FindBy(xpath="//input[@id=\"email\"]") 
	WebElement emailInput;
	
	@FindBy(xpath="//input[@id=\"mobileNo\"]") 
	WebElement mobileNumberInput;
	
	@FindBy(xpath="//div[@class=\"msg-error show\"]") 
	WebElement emailErrorMessage;
		
	@FindBy(xpath="(//div[@class=\"msg-error show\"])[2]") 
	WebElement numberErrorMessage;
	
	@FindBy(xpath="//*[@class=\"pb-logo\"]") 
	 WebElement home;
	
	public void returnHome()
	{
		home.click();
	}	
	
	public void fillCarNumber(String carNumber)
	{
		inputOfOldCar.sendKeys(carNumber);
	}	
	
	public void clickOnViewPlan()
	{
		viewPlan.click();
	}
	

    public String carName() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	return carName.getText();
    }
	
    public void clcikOnBuyNewCar() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	buyNewCar.click();
    }
    
    
    public void selectCity() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    	js.executeScript("arguments[0].click()",city);
    	city.click();
    	
    }
    
    public void selectCityNumber() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	cityNumber.click();
    }
    
    public void clickCarBrand() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	carCompany.click();
    }
    
    public void selectCarModal() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	carModal.click();
    	
    }
    public void selectFuelType() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	fuelType.click();
    }
    
    public void selectCarVariant() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	carVariant.click();
    }
    
    public void fillNameInput(String name) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	nameInput.clear();
    	nameInput.sendKeys(name);
    }
    
    public void fillemailInput(String email) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	emailInput.clear();
    	emailInput.sendKeys(email);
    }
    
    public String getEmailErrorMessage() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	String err=emailErrorMessage.getText();
    	System.out.println(err);
    	return err;
    }
    
    
    public void fillNumberInput(String number) throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	mobileNumberInput.clear();
    	mobileNumberInput.sendKeys(number);
    	Thread.sleep(2000);
    	mobileNumberInput.sendKeys(Keys.BACK_SPACE);
    	mobileNumberInput.sendKeys(Keys.ENTER);
    }
    
    public String getnumberErrorMessage() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	String err=numberErrorMessage.getText();
    	System.out.println(err);
    	return err;
    }


}
