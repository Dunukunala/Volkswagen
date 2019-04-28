package Steps;

import com.cucumber.listener.ExtentProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
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

}
