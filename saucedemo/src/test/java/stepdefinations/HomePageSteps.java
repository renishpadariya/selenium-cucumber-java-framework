package stepdefinations;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageSteps {
	private HomePage homepage;
	public HomePageSteps() {
        homepage = new HomePage(DriverFactory.getDriver());
    }
	
	@When("user selects the highest price item")
	public void user_selects_the_highest_price_item()  {
		homepage.select_highest_price_item();
	    
	}

	@Then("user adds the selected item to the cart")
	public void user_adds_the_selected_item_to_the_cart()  {
		homepage.add_selected_item_to_cart();
	   
	}



}
