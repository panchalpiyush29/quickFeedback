package config;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    InputStream inputStream;

    public String getBrowserName() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found");
        }
        return prop.getProperty("browser");
    }

    public WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/piyushpanchal/chromedriver");
            driver = new ChromeDriver();
            return driver;

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/piyushpanchal/geckodriver");
            driver = new FirefoxDriver();
            setBrowserProperties();
            return driver;
        } else {
            return null;
        }
    }

    public void setBrowserProperties() {
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public ReportBuilder reportBuilder() {
        // json files
        List<String> jsonFiles = Collections.singletonList("target/cucumber-json-report.json");


        // configuration
        File reportOutputDirectory = new File("target");
        String projectName = "quickFeedback";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        // initialise report builder
        return new ReportBuilder(jsonFiles, configuration);
    }
}
