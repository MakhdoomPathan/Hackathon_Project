package StepDefinition;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarInsuarance;
import pageObjects.HomePage;
import testBase.BaseClassCucumber;

public class CarInsuaranceSteps extends BaseClassCucumber {
	
	
	CarInsuarance cr;
	HomePage home;
	@When("User will click on car insuarance")
	public void user_will_click_on_car_insuarance() {
		BaseClassCucumber.getLogger().info("********** User is clicking on car insurance ********");
		cr=new CarInsuarance(driver);
		home=new HomePage(driver);
    	boolean navigated= home.clickOnCarInsuarance();
        Assert.assertEquals(navigated,true);
	}

	@When("fill the car number and click on view price")
	public void fill_the_car_number_and_click_on_view_price() throws IOException {
		BaseClassCucumber.getLogger().info("********** filling the car number and click on view price ********");
		cr.fillCarNumber(getProperties().getProperty("carNumber"));
		cr.clickOnViewPlan();
	}

	@Then("check if the correct car has been identified")
	public void check_if_the_correct_car_has_been_identified() throws IOException {
		BaseClassCucumber.getLogger().info("********** checking if the correct car has been identified ********");
		String carName=cr.carName() ;
		cr.returnHome();
		Assert.assertEquals(carName,getProperties().getProperty("carName"));
	}
	
	

	@When("fill the details")
	public void fill_the_details() {
		BaseClassCucumber.getLogger().info("********** filling the details ********");
		try {
			home.clickOnCarInsuarance();
			cr.clcikOnBuyNewCar();
			cr.selectCity();
			cr.selectCityNumber();
			cr.clickCarBrand();
			cr.selectCarModal();
			cr.selectFuelType();
			cr.selectCarVariant();
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@Then("fill personal info check for invalid email error")
	public void fill_personal_info_check_for_invalid_email_error() {
		BaseClassCucumber.getLogger().info("********** filling personal info check for invalid email error ********");
		try {
			cr.fillNameInput(getProperties().getProperty("name"));
			cr.fillemailInput(getProperties().getProperty("email"));
			String emailError=cr.getEmailErrorMessage();
			Assert.assertEquals(emailError,getProperties().getProperty("email_error_message"));
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}

	@Then("fill incorrect number and check for invalid number error")
	public void fill_incorrect_number_and_check_for_invalid_number_error() {
		BaseClassCucumber.getLogger().info("********** filling incorrect number and checking for invalid number error ********");
		try {
			cr.fillNumberInput(getProperties().getProperty("number"));
			String numberError=cr.getnumberErrorMessage();
			Assert.assertEquals(numberError,getProperties().getProperty("number_error_message"));
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
	}
	

}
