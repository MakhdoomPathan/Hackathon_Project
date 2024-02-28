package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;
import testBase.BaseClassCucumber;
import utilities.ExcelUtility;

public class BasePage extends BaseClass{

  public  static WebDriver driver;
  public static ExcelUtility ex;
  
	public BasePage(WebDriver driver)
	{
		BasePage.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			ex=new ExcelUtility(System.getProperty("user.dir")+prop.getProperty("excel_file_path"));
//			ex=new ExcelUtility(System.getProperty("user.dir")+BaseClassCucumber.getProperties().getProperty("excel_file_path"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
