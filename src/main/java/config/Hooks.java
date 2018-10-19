package config;

import cucumber.api.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static org.openqa.selenium.OutputType.BYTES;

public class Hooks extends Browser {


    @BeforeSuite(alwaysRun = true)
    public WebDriver setUp() {
        try {
            String browserName = getBrowserName();
            return getDriver(browserName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }

    @AfterTest
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            final byte[] screenshot = takesScreenshot.getScreenshotAs(BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        reportBuilder().generateReports();
        driver.close();

    }
}