package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private ConfigReader configreader;
	private DriverFactory driverfactory;
	private WebDriver driver;
	Properties prop;
	
	@Before (order = 0)
	public void getproperty()
	{
	   configreader=new ConfigReader();
	  prop =configreader.init_prop();
			
	}
	@Before (order =1)
	public void launchbrowser()
	{
		String browsername = System.getProperty("browser") != null
        ? System.getProperty("browser")
        : prop.getProperty("browser");
		driverfactory= new DriverFactory();
		driver=driverfactory.init_driver(browsername);
	}
	@After (order=0)
	public void quitbrowser()
	{
		driver.quit();
	}
	@After (order =1)
	public void teardown(Scenario scenario)
	{
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}

	}



}
