package testCases;



import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HealthInsuarance;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_HealthInsuarance extends BaseClass {
	
	
	@Test(priority=0,groups= {"master","smoke"})
	public void navigateToHealthInsuarance() throws InterruptedException, ParseException {
		logger.info("**********navigate to health insurance********");
		try {
//			cr=new CarInsuarance(driver);
			cr.returnHome();
			he=new HealthInsuarance(driver);
			System.out.println("...........asdsa..........");
			boolean navigate= he.clcikOnHealthInsuarance();
			Assert.assertEquals(navigate,true);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Test(priority=1,groups= {"master","sanity"})
	public void fillHealthInsuaranceDetails() throws InterruptedException, ParseException {
		logger.info("**********fill health insurance details ********");
		try {
//		he=new HealthInsuarance(driver);
		 he.clcikOnHealthInsuarance();
		 he.clcikOnContinue();
		 he.selectAge();
		 he.clcikOnContinue();
		 he.selectCity();
		 he.fillNameInput(prop.getProperty("name"));
		 he.fillNumberInput(prop.getProperty("number"));
		 he.clcikOnContinue();
		 he.clcikOnNoDisease();
		 he.clcikOnNo();
		 he.clcikOnViewPlan();
		 Thread.sleep(5000);
		 String title=driver.getTitle();
		 Assert.assertEquals(title,prop.get("health_inurance_plan_title"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test(priority=2,groups= {"master","regression"})
	public void displayHealthInsuaranceCompany(){
		logger.info("********** display health insurance company ********");
		
		 try {
			he.getDetailsOfInsuarance();
			 driver.get(prop.getProperty("appURL"));
			 Thread.sleep(2000);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=3,groups= {"master","regression"})
	public void displayHealthInsuarance() throws InterruptedException, ParseException {
		logger.info("********** display health insurance ********");
		home=new HomePage(driver);
		boolean ans=home.getHealthInsuaranceList();
		Assert.assertEquals(ans,true);
		
	}
	
	
	
	
		
}








