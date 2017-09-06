package com.epam.elena_bolotova.mentoring.task9.tests.cucumber_tests;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        strict = true,
        plugin = {
                "json:target/cucumber-report.json",
                "html:target/cucumber-report"
        },
        tags = "@loginTests",
        features = "src/test/resources/features",
        glue = { "com.epam.elena_bolotova.mentoring.task9.tests.cucumber_steps" })

public class IncorrectLogInCucumberTest extends BaseCucumberTest {
}
