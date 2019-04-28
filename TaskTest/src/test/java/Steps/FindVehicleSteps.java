package Steps;

import Pages.FindVehiclePage;
import base.testBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class FindVehicleSteps extends testBase {

    @When("^I enter vehicle \"([^\"]*)\" in the input field$")
    public void i_enter_vehicle_in_the_input_field(String arg1)  {
        FindVehiclePage findvehiclepage = PageFactory.initElements(driver, FindVehiclePage.class);
        findvehiclepage.enter_Vehicle_registration_Number(arg1);

    }

    @When("^I click on Find Vehicle$")
    public void i_click_on_Find_Vehicle()  {
        FindVehiclePage findvehiclepage = PageFactory.initElements(driver, FindVehiclePage.class);
        findvehiclepage.click_FindVehicle();
    }

    @Then("^I should see the Vehicle detail$")
    public void i_should_see_the_Vehicle_detail() {
        FindVehiclePage findvehiclepage = PageFactory.initElements(driver, FindVehiclePage.class);
        findvehiclepage.verify_Result();
    }

}
