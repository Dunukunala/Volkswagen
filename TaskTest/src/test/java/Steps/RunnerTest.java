package Steps;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue= {"Steps"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"},
        monochrome = true,
        tags = {"@Test"})



public class RunnerTest {
    @BeforeClass
public static void setup() {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
    String repName = "Volkswagen_Test-Report-" + timeStamp + ".html";
    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
    extentProperties.setReportPath(System.getProperty("user.dir") + "/target/cucumber-reports/" + repName);
}
        @AfterClass
  public static void writeExtentReport() {
    Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    Reporter.setSystemInfo("Machine", 	"MacOS 10.13.6 (17G65)");
    Reporter.setSystemInfo("Selenium", "3.11.0");
    Reporter.setSystemInfo("Maven", "3.5.3");
    Reporter.setSystemInfo("Java Version", "1.8.0_92");
    Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
  }

}
