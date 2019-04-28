package Pages;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertTrue;

public class HomePage extends testBase {

    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/a/img")
    public static WebElement heading;

    @FindBy(how = How.XPATH, using = "/html/head/title")
    public static WebElement tittle;

    public void verify_Heading() {
        heading.isDisplayed();
    }

    public void verify_Tittle() {
        tittle.isDisplayed();
        String actualTitle = "";
        String expectedTitle = "Dealer Portal";
        actualTitle = driver.getTitle();
        assertTrue(driver.getTitle().contains("Dealer Portal"));

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Valid Web site!");
        } else {
            System.out.println("Invalid WebSite OR Site is DOWN");
        }
        System.out.println("ActualTitle is:-  " + actualTitle);

    }
}