package regression;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}
//        ,
//        features = "src/test/resources/regression/LoginTests.feature"
//        tags = {"@1"}
        //dryRun = true
)
public class TestRunner {


    static WebDriver driver;

    @BeforeClass
    public static void startBrowsr() throws MalformedURLException {
        driver = BrowserFactory.getDriver();
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
    }

    @AfterClass
    public static void stop() {
//        driver.quit();
        driver = null;
    }


}
