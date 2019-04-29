package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testBase {
   public static WebDriver driver = null;
   public static Properties CONFIG = null;


    public void initialize() throws IOException {

        if (driver == null) {

            CONFIG = new Properties();

            FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            CONFIG.load(fn);

            if (CONFIG.getProperty("browser").equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Driver/geckodriver");
                driver = new FirefoxDriver();
            } else if (CONFIG.getProperty("browser").equals("chrome")) {
               System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver");
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);


            } else if (CONFIG.getProperty("browser").equals("IE")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer");
                driver = new InternetExplorerDriver();
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


    public void closeBrowser() {
        driver.close();
    }







}
