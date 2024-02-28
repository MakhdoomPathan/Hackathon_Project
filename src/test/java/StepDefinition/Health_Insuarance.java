package StepDefinition;

import java.io.IOException;


import java.time.Duration;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HealthInsuarance;
import pageObjects.HomePage;
import testBase.BaseClassCucumber;

public class Health_Insuarance extends BaseClassCucumber {
	
//	WebDriver driver;
	
	HealthInsuarance he;
	HomePage home;
	
	@Given("The user is on Homepage")
	public void the_user_is_on_homepage() throws IOException {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 BaseClassCucumber.getLogger().info("Goto my Home Page--> ");
//	 try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	 driver.get(getProperties().getProperty("appURL"));
	 String title=driver.getTitle();
	 Assert.assertEquals(title,"Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car");

	}

	@When("User will click on Health insurance")
	public void user_will_click_on_Health_insurance() {
		BaseClassCucumber.getLogger().info("********** User is clicking on Health Insurance ********");
		 he=new HealthInsuarance(driver);
		 boolean navigate= he.clcikOnHealthInsuarance();
		 Assert.assertEquals(navigate,true);
	}

	@When("fill the details and click on view plans")
	public void fill_the_details_and_click_on_view_plans() throws IOException, InterruptedException {
		BaseClassCucumber.getLogger().info("********** filling the details and clicking on view plans ********");
		 he.clcikOnHealthInsuarance();
		 he.clcikOnContinue();
		 he.selectAge();
		 he.clcikOnContinue();
		 he.selectCity();
		 he.fillNameInput(getProperties().getProperty("name"));
		 he.fillNumberInput(getProperties().getProperty("number"));
		 he.clcikOnContinue();
		 Thread.sleep(2000);
		 he.clcikOnNoDisease();
		 Thread.sleep(2000);
		 he.clcikOnNo();
		 he.clcikOnViewPlan();
		 Thread.sleep(5000);
		 String title=driver.getTitle();
		 Assert.assertEquals(title,getProperties().get("health_inurance_plan_title"));
	}

	@Then("retrieve insurance plan")
	public void retrieve_insurance_plan() throws IOException {
		BaseClassCucumber.getLogger().info("********** Retrieving insurance plan ********");
		try {
			
			he.getDetailsOfInsuarance();
			driver.get(getProperties().getProperty("appURL"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Then("retrieve the Health Insurance Plans")
	public void retrieve_the_Health_Insurance_Plans() throws IOException {
		BaseClassCucumber.getLogger().info("********** Retrieving the health insurance plans ********");
		home=new HomePage(driver);
		boolean ans=home.getHealthInsuaranceList();
		Assert.assertEquals(ans,true);
	}

	

}
