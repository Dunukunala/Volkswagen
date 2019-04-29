package Steps;

import Pages.HomePage;
import base.testBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePageSteps extends testBase {
    @Before
public void setup() throws IOException {
    initialize();
}
    @After
    public void TearDown () {
        closeBrowser();
    }
    @Given("^User is on the Volkswagen Financial Services Home Page on URL \"([^\"]*)\"$")
    public void user_is_on_the_Volkswagen_Financial_Services_Home_Page_on_URL(String arg1)  {
     driver.get(CONFIG.getProperty("URL"));
     //   driver.get("https://www.bbc.co.uk/");
    }

    @Then("^I should see Volkswagen Financial Services displayed$")
    public void i_should_see_Volkswagen_Financial_Services_displayed()  {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.verify_Heading();
    }

    @Then("^I should see page tittle Dealer Portal$")
    public void i_should_see_page_tittle_Dealer_Portal()  {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.verify_Tittle();
    }
}
