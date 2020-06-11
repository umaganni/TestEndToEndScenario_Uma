import static org.junit.Assert.assertTrue;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}

)
public class TestRunner
{
    public static final String USERNAME = "uma107";
    public static final String AUTOMATE_KEY = "7puujV9FAYnrLS525B5h";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static WebDriver driver;

    @BeforeClass
    public static void startBrowser() throws MalformedURLException, InterruptedException {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "49.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "XP");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        driver = new RemoteWebDriver(new URL(URL), caps);

        Thread.sleep(10000);

    }
    @AfterClass
    public static void closeBrowser()
    {
        driver.quit();
    }
}
