package testCases;




import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CarInsuarance;
import testBase.BaseClass;

public class TC_CarInsuarance extends BaseClass {
	
	

	@Test (priority=0 ,groups= {"master","smoke"})
	public void navigateToCarInsuarancePage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logger.info("********** navigate to car insurance page ********");
        cr=new CarInsuarance(driver);
    	boolean navigated= home.clickOnCarInsuarance();
        Assert.assertEquals(navigated,true);
      
	}
	
	@Test (priority=1,groups= {"master","smoke"})
	public void navigateToTravelInsuarancePage() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("**********navigate to travel insurance page ********");
        try {
        	Thread.sleep(2000);
        	String title=driver.getTitle();
        	Assert.assertEquals(title,prop.getProperty("car_insuarance_title"));
        }catch(Exception e) {
        	System.out.println(e);	
        }
	}
	
	@Test(priority=2,groups= {"master","smoke"})
	public void CarInsuaranceForOldCar() throws InterruptedException
	{
		logger.info("********** car insurance for old car ********");
		try {
		
			cr.fillCarNumber(prop.getProperty("carNumber"));
			cr.clickOnViewPlan();
			String carName=cr.carName() ;
			cr.returnHome();
			Assert.assertEquals(carName,prop.getProperty("carName"));
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
			
	}
	
	
	@Test(priority=3,groups= {"master","sanity"})
	public void fillingCarInfo() throws InterruptedException
	{
		logger.info("********** filling car info ********");
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
	
	@Test(priority=4,groups= {"master","sanity"})
	public void fillingPersonalInfo() throws InterruptedException
	{
		logger.info("**********filling personal info ********");
		try {
			cr.fillNameInput(prop.getProperty("name"));
			cr.fillemailInput(prop.getProperty("email"));
			String emailError=cr.getEmailErrorMessage();
			Assert.assertEquals(emailError,prop.getProperty("email_error_message"));
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
			
	}
	
	@Test(priority=5,groups= {"master","sanity"})
	public void fillingPersonalInfoNumber() {
		logger.info("********** filling personal info number ********");
		try {
			cr.fillNumberInput(prop.getProperty("number"));
			String numberError=cr.getnumberErrorMessage();
			Assert.assertEquals(numberError,prop.getProperty("number_error_message"));
		}catch(Exception e) {
			System.out.println(e);
			Assert.assertTrue(false);
		}
		
	}
			
}








