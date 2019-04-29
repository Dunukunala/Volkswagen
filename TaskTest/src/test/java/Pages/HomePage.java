package Pages;

import base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
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
        
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }

                for (String t : linkTexts) {
            driver.findElement(By.linkText(t));
            if (driver.getTitle().equals(underConsTitle)) {
                System.out.println("\"" + t + "\""
                        + " is under construction.");
            } else {
                System.out.println("\"" + t + "\""
                        + currentURL +" is working.");
            }

        }

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Valid Web site!");
        } else {
            System.out.println("Invalid WebSite OR Site is DOWN");
        }
        System.out.println("ActualTitle is:-  " + actualTitle);
        System.out.println("ExpectedTitle is:-  " + expectedTitle );
    }
}
