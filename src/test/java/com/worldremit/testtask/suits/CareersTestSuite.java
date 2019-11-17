package com.worldremit.testtask.suits;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/careers"
        },
        glue = {"com.worldremit.testtask.definitions"},
        tags = {"not @ignore"}
)
public class CareersTestSuite {
}
