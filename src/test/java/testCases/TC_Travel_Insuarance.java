package testCases;



import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.TravelInsuarance;
import pageObjects.Travel_Insuarance_Plan;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_Travel_Insuarance extends BaseClass {
	
	

	@Test (priority=0,groups= {"master","sanity"})
	public void ClickOnTravelInsuarancePage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        home=new HomePage(driver);
        logger.info("**********Chrome is initialized ********");
    	boolean navigated;
        try {
        	navigated=  home.clickOnTravelInsuarance();
        }catch(Exception e) {
        	System.out.println(e);
        	navigated=  false;	
        }
       Assert.assertEquals(navigated,true);
      
	}
	
	@Test (priority=1,groups= {"master","smoke"})
	public void navigateToTravelInsuarancePage() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("********** navigate to TravelInsurance page ********");
        try {
        	Thread.sleep(2000);
        	String title=driver.getTitle();
        	Assert.assertEquals(title,prop.getProperty("travel_insuarance_title"));
        }catch(Exception e) {
        	System.out.println(e);	
        }
	}
	
	@Test(priority=2,groups= {"master","sanity"})
	public void fillingInfoAndViewPlan() throws InterruptedException
	{
		try {
			te=new TravelInsuarance(driver);
            logger.info("**********filling info and view plan ********");
//            Thread.sleep(2000);
			te.selectCountry();
			Thread.sleep(2000);
			te.clcikOnNext();
			Thread.sleep(3000);
			te.selectDate();
			te.clcikOnNext();
			logger.info("**********Navigated to travel inurance page ********");
			te.selectNumberOfMember();
			te.selectage1();
			te.selectage2();
			te.clcikOnNext();
			te.medicalCondition();
			te.clcikOnNext();
			te.enterMobileNumber(prop.getProperty("phone_number"));
			logger.info("**********Navigated to travel inurance page ********");
			Thread.sleep(3000);
			te.viewPlan();
			WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(15));
			System.out.println(prop.getProperty("travel_inurance_plan_title")+">................................frgdg>>>>>>>>>>>>>");
		    boolean status= mywait.until(ExpectedConditions.titleContains(prop.getProperty("travel_inurance_plan_title")));
		 
		   Assert.assertEquals(status,true);
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
			
	}
	@Test(priority=3,groups= {"master","sanity"})
	public void settingFilter() {
		logger.info("********** Displaying three lowest travel insurance plan ********");
		try {
			plan=new Travel_Insuarance_Plan(driver);
			plan.selectStudentPlan();
			Thread.sleep(2000);
			plan.lowToHighFilter();
			plan.viewMorePlan();
			Thread.sleep(2000);
			boolean status=plan.studentPlan.isSelected();
			System.out.println(status+" .          .       .            .......dsad.........");
			Assert.assertEquals(status, true);
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=4)
	public void RetrievingInsuaranceDetails() {
		logger.info("********** Retrieving Insurance Details ********");
		try {
			plan.getDetailsOfInsuarance();
			home.returnHome();
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
		
	}
		
}








