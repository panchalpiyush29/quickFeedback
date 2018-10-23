package config;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks extends CucumberReportBuilder {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        System.out.println("Start of suite");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        reportBuilder().generateReports();
        System.out.println("End of suite");
    }
}