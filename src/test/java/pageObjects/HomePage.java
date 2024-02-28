package pageObjects;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
		@FindBy(xpath="(//div[@class='prd-icon add shadowHandler short'])[7]")
		public
		 WebElement travelInsuarance;
		
		@FindBy(xpath="(//div[@class='prd-icon add shadowHandler short'])[4]")
		 WebElement carInsuarance;
		
		@FindBy(xpath="//a[text()=\"Insurance Products \"]")
		 WebElement insuaranceProductsMenu;
				
		@FindBy(xpath="(//div[@class=\"ruby-col-3 hidden-md\"])[2]//ul//li")
		 List<WebElement> healthInsuaranceList;
		
		@FindBy(xpath="//a[text()=\"Policybazaar\"]") 
		 WebElement home;
		
		public void returnHome() {
			home.click();
		}

		public boolean clickOnTravelInsuarance() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			try {
				travelInsuarance.click();
				return true;
			}catch(Exception e) {
				System.out.println(e);
				return false;
			}
		}
		
		public boolean clickOnCarInsuarance() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			try {
				carInsuarance.click();
				return true;
			}catch(Exception e) {
				System.out.println(e);
				return false;
			}
		}
		
		public boolean getHealthInsuaranceList() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			try {
				insuaranceProductsMenu.click();
				ex.setCellData("healthInsuarance", 0,0,"Health Insuarance List");
				for (int i =0;i<healthInsuaranceList.size();i++) {
					String healthInsuarance=healthInsuaranceList.get(i).getText();
					ex.setCellData("healthInsuarance", i+2,0,healthInsuarance);
					System.out.println(healthInsuarance);
			    }
				return true;
			}catch(Exception e) {
				System.out.print("..................adssssssssssssss.................");
				System.out.println(e);
				return false;
			}
		}
		
		
		


}
