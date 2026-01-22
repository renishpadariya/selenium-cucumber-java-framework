package stepdefinations;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private HomePage homepage;
	private LoginPage loginpage;
    private Properties prop;
    private ConfigReader configReader;
	public LoginPageSteps() {
		loginpage= new LoginPage(DriverFactory.getDriver()); 
        configReader = new ConfigReader();
        prop = configReader.init_prop();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get(prop.getProperty("url"));
	    	
	}

	@When("user enters valid username")
	public void user_enters_valid_username() {
	    loginpage.enter_username(prop.getProperty("username"));
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
	    loginpage.enter_password(prop.getProperty("password"));
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		homepage=loginpage.click_on_login_button();
	    	
	}

	@Then("user should see products on the page")
	public void user_should_see_products_on_the_page() {
	    assertTrue(homepage.verify_products_page());
		
	}


}
