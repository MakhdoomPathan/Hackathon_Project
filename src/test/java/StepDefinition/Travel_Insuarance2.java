package StepDefinition;




import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.TravelInsuarance;
import pageObjects.Travel_Insuarance_Plan;
import testBase.BaseClassCucumber;

public class Travel_Insuarance2 extends BaseClassCucumber {
	
//	WebDriver driver;
	
	TravelInsuarance te;
	HomePage home;
	Travel_Insuarance_Plan plan;
	

@When("User will click on Travel insurance")
public void user_will_click_on_travel_insurance() {
	BaseClassCucumber.getLogger().info("********** User is clicking on Travel insurance ********");
	 home=new HomePage(driver);
 	boolean navigated;
     try {
     	navigated=  home.clickOnTravelInsuarance();
     }catch(Exception e) {
     	System.out.println(e);
     	navigated=  false;	
     }
    Assert.assertEquals(navigated,true);
}

@When("fill the details and click on view plans for travel insurance")
public void fill_the_details_and_click_on_view_plans_for_travel_insurance() {
	BaseClassCucumber.getLogger().info("********** Filling the details and clicking on view plans for travel insurance ********");
	try {
		te=new TravelInsuarance(driver);
        logger.info("**********Navigated to travel insurance page ********");
		te.selectCountry();
		Thread.sleep(2000);
		te.clcikOnNext();
		Thread.sleep(3000);
		te.selectDate();
		te.clcikOnNext();
		logger.info("**********Navigated to travel insurance page ********");
		te.selectNumberOfMember();
		te.selectage1();
		te.selectage2();
		te.clcikOnNext();
		te.medicalCondition();
		te.clcikOnNext();
		te.enterMobileNumber(getProperties().getProperty("phone_number"));
		logger.info("**********Navigated to travel insurance page ********");
		Thread.sleep(3000);
		te.viewPlan();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(15));
		System.out.println(getProperties().getProperty("travel_insurance_plan_title")+">................................frgdg>>>>>>>>>>>>>");
	    boolean status= mywait.until(ExpectedConditions.titleContains(getProperties().getProperty("travel_inurance_plan_title")));
	 
	   Assert.assertEquals(status,true);
	}catch(Exception e) {
		System.out.println(e);
		Assert.assertTrue(false);
	}
}

@Then("retrieve {int} lowest insurance plan")
public void retrieve_lowest_insurance_plan(Integer int1) {
	BaseClassCucumber.getLogger().info("********** Retrieving the lowest insurance plan ********");
	try {
		plan=new Travel_Insuarance_Plan(driver);
		plan.selectStudentPlan();
		Thread.sleep(2000);
		plan.lowToHighFilter();
		plan.viewMorePlan();
		boolean status=plan.studentPlan.isSelected();
		plan.getDetailsOfInsuarance();
		Assert.assertEquals(status, true);
	}catch(Exception e) {
		System.out.println(e);
		Assert.assertTrue(false);
	}
}


	

}
