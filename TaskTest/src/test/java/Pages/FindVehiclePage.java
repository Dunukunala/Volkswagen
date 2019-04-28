package Pages;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FindVehiclePage extends testBase {  @FindBy(how = How.ID, using = "vehicleReg")
public static WebElement vehicleregistrationnumber;


    @FindBy(how = How.ID, using = "search")
    public static WebElement findvehicle;

    @FindBy(how = How.CSS, using = "#page-container > div:nth-child(4)")
    public static WebElement result;

    public void enter_Vehicle_registration_Number(String regnmber) {
        vehicleregistrationnumber.sendKeys(regnmber);

    }

    public void click_FindVehicle() {
        findvehicle.click();
    }

    public void verify_Result() {
        result.isDisplayed();
        String text = result.getText();
        if (result.isEnabled() && text.contains("Result for :")) {

            System.out.println("Vehicle Details found Successfully :");
            System.out.println("Vehicle Details " + "\n" + result.getText());

        } else {
            System.out.println("Sorry record not found");


        }

    }
}
