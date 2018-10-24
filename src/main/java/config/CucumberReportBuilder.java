package config;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CucumberReportBuilder {

    public static ReportBuilder reportBuilder() {
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
