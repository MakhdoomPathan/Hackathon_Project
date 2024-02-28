package TestRunner;




	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	 

	@RunWith(Cucumber.class)
	@CucumberOptions(
      features= {".//FeatureFiles/Travel_Insuarance.feature"},
	 glue = "StepDefinition",
	plugin = {"pretty", "html:Cucumber_Reports/myreport.html",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//	"rerun:target/rerun:txt"}
	dryRun = false, monochrome = true, publish = true

	 
	
	// tags="@sanity"
	// tags="@sanity and @regression"
	// tags="@sanity or @regression"
	// tags="@sanity and not @regression"
	)
	public class Runner {

	 

	}


