package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HealthInsuarance extends BasePage{


		public HealthInsuarance(WebDriver driver){
			super(driver);
			
		}	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	
	@FindBy(xpath="(//*[@class=\"shadowHandlerBox\"])[2]") 
	WebElement healthInsuarance;
	
	@FindBy(xpath="(//*[@class=\"memberSelection__block\"])[3]") 
	WebElement self;
	
	
	@FindBy(xpath="//input[@id=\"regNoTextBox\"]") 
	WebElement inputOfOldCar;
	
	
	@FindBy(xpath="//*[@class=\"primaryButton\"]") 
	WebElement continu;
	
	@FindBy(xpath="//*[@id=\"Self\"]") 
	WebElement age;
	

	@FindBy(xpath="//*[text()=\"Pune\"]") 
	WebElement cityName;
	
	@FindBy(xpath="//*[@id=\"fullName\"]") 
	WebElement nameInput;
	
	@FindBy(xpath="//*[@id=\"mobile\"]") 
	WebElement mobileNumberInput;
	
	
	@FindBy(xpath="//*[@id=\"ped_last\"]") 
	WebElement noDisease;
	
	
	@FindBy(xpath="//*[@id=\"corp_no\"]") 
	WebElement no;
	
	@FindBy(xpath="//*[@class=\"primaryButton\"]") 
	WebElement viewplan;
	
	@FindBy(xpath="//*[@class=\"quotes_rvmp_card__content__plan_header__name\"]") 
	List <WebElement> companyNames;
	
	@FindBy(xpath="//*[@class=\"primaryMainCta\"]") 
	List<WebElement> premiumPerMonth;
	
	@FindBy(xpath="//*[@class=\"pb-logo\"]") 
	 WebElement home;
	
	@FindBy(xpath="//*[@id=\"indexBody\"]") 
	 WebElement hover;
	
	@FindBy(xpath="//*[@class=\"navbar-brand\"]") 
	 WebElement home1;
	
	
	@FindBy(xpath="//*[@id=\"vwo-survey-close-icon-title\"]") 
	 WebElement popUpNo;
	
	public void returnHome()
	{
		home.click();
	}	
	
	
	public boolean clcikOnHealthInsuarance()
	{
		try {
			healthInsuarance.click();
			return true;
		}
	catch(Exception e) {
		return false;
	  }
	}	
	
	public void clickOnSelf()
	{
		self.click();
	}
	

    public void clcikOnContinue() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	try {
    		
//    		js.executeScript("arguments[0].moveToElement()", hover);
    		Thread.sleep(3000);
    		js.executeScript("arguments[0].click()", continu);
//    		continu.click();
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
	
    
    public void selectAge() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    	js.executeScript("arguments[0].click()",city);
    	try {
    		Thread.sleep(2000);
    		Select sc=new Select(age);
    		sc.selectByValue("22");
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }
    
    public void selectCity() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	Thread.sleep(2000);
    	cityName.click();
    }
    
    public void fillNameInput(String name) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	nameInput.clear();
    	nameInput.sendKeys(name);
    	
    }
    
    public void fillNumberInput(String number) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	mobileNumberInput.clear();
    	mobileNumberInput.sendKeys(number);
    	
    }
    
    
    public void clcikOnNoDisease() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	try {
    		Thread.sleep(2000);
    		js.executeScript("arguments[0].click()",noDisease);
//			noDisease.click();
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
   
    public void clcikOnNo() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	Thread.sleep(2000);
        no.click();
    }
    
    public void clcikOnViewPlan() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	try {
    		Thread.sleep(2000);
    		js.executeScript("arguments[0].click()",viewplan);
    	}catch(Exception e) {
    		System.out.println(e);
    		}
    	}
    public void getDetailsOfInsuarance() throws IOException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	ex.setCellData("HealthInsuarance_Company", 0, 0,"Comapnay Name");
    	ex.setCellData("HealthInsuarance_Company", 0, 1,"Price Of Insuarance");
        for (int i =0;i<premiumPerMonth.size();i++) {
        	try {
        		String companyName= companyNames.get(i).getText();
        		ex.setCellData("HealthInsuarance_Company", i+2, 0,companyName);
        		String price=premiumPerMonth.get(i).getText();
        		ex.setCellData("HealthInsuarance_Company", i+2, 1,price);
        		System.out.println(companyName+" ........... ffdsffdssd ....... "+price);
        	}catch(Exception e) {
        		System.out.println(e);
        	}
        	
        }
      
    }
    
   
    
  
    
   

}
