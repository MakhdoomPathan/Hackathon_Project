package pageObjects;

import java.io.IOException;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Travel_Insuarance_Plan extends BasePage{

	JavascriptExecutor js=(JavascriptExecutor)driver;

		public Travel_Insuarance_Plan(WebDriver driver){
			super(driver);
		}	
	
	
	@FindBy(xpath="//span[@class=\"exitIntentPopup__box__closePop\"]") 
	WebElement popupCrossButton;
	
	@FindBy(xpath="(//summary)[2]") 
	WebElement planTypeOptions;
	
	@FindBy(xpath="//input[@id=\"studentTrip\"]")
	public 
	WebElement studentPlan;
	
	@FindBy(xpath="//input[@id=\"Traveller_1\"]") 
	WebElement traveller1;
	
	@FindBy(xpath="//input[@id=\"Traveller_2\"]") 
	WebElement traveller2;
	
	
	@FindBy(xpath="//*[@id=\"feet\"]") 
	WebElement travelDuration;
	
	@FindBy(xpath="	//button[text()=\"Apply\"]") 
	WebElement applyButton;
	
	
	@FindBy(xpath="//p[text()='Sort by']") 
	WebElement sortByOptions;
	
	@FindBy(xpath="//input[@id='17_sort']") 
	WebElement lowToHighOption;
	
	
	@FindBy(xpath="//div[@class=\"cardWrapper__showMore \"]") 
	List<WebElement> oneMoreOption;
	
	@FindBy(xpath="//div //p[@class=\"quotesCard--insurerName\"]") 
	List<WebElement> listOfComapny;
	
	@FindBy(xpath="//div[@class=\"quotesCard__quoteWrap   \"] //span[@class=\"premiumPlanPrice\"]") 
	List<WebElement> listOfPrices;
	
    
    public void selectStudentPlan() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	studentPlan.click();
    	Thread.sleep(2000);
    	traveller1.click();
    	traveller2.click();
    	Select sc=new Select(travelDuration);
    	sc.selectByValue("1");
    	applyButton.click();
    }
    
    public void lowToHighFilter() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	js.executeScript("arguments[0].click()",sortByOptions);
    	js.executeScript("arguments[0].click()",lowToHighOption);
    }
    
    public void viewMorePlan() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	for (int i =0;i<oneMoreOption.size();i++) {
    		WebElement viewmore=oneMoreOption.get(i);
    		js.executeScript("arguments[0].click()",viewmore);
    	}
    }
    
    public void getDetailsOfInsuarance() throws IOException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	ex.setCellData("TravelInsuarance", 0, 0,"Comapnay Name");
    	ex.setCellData("TravelInsuarance", 0, 1,"Price Of Insuarance");
        for (int i =0;i<3;i++) {
        	
        	String companyName=listOfComapny.get(i).getText();
        	ex.setCellData("TravelInsuarance", i+1, 0,companyName);
        	String price=listOfPrices.get(i).getText();
        	ex.setCellData("TravelInsuarance", i+1, 1,price);
        	
        	System.out.println(companyName+" "+price);
        }
      
    }


}
