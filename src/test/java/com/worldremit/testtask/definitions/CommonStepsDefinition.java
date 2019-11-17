package com.worldremit.testtask.definitions;

import com.worldremit.testtask.steps.CommonSteps;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CommonStepsDefinition {
    @Steps
    private CommonSteps commonSteps;

    @Given("^I enter '(.*?)'$")
    public void iEnterUrl(String url) {
        commonSteps.navigateTo(url);
    }
}
