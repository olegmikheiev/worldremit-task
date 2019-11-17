package com.worldremit.testtask.definitions;

import com.worldremit.testtask.steps.CareersSteps;
import com.worldremit.testtask.steps.PositionSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CareersStepsDefinition {
    @Steps
    private CareersSteps careersSteps;

    @Steps
    private PositionSteps positionSteps;

    @Given("^I am on the careers page$")
    public void iAmOnTheCareersPage() {
        careersSteps.openCareersPage();
        careersSteps.verifyCareersPageOpen();
    }

    @When("^I go to open position form$")
    public void iGoToOpenPositionForm() {
        careersSteps.goToOpenPositionsForm();
    }

    @When("^I select a department '(.*?)'$")
    public void iSelectADepartment(String department) {
        careersSteps.selectDepartment(department);
    }

    @When("^I select an office as '(.*?)'$")
    public void iSelectAnOfficeAs(String office) {
        careersSteps.selectOffice(office);
    }

    @When("^I find a position for '(.*?)'$")
    public void iFindAPositionForQA(String role) {
        careersSteps.findPositionFor(role);
    }

    @When("^I open '(.*?)' position$")
    public void iOpenQAPosition(String role) {
        careersSteps.openPosition(role);
        positionSteps.verifyPositionPageIsOpen();
        positionSteps.verifyPositionTitleMatches(role);
    }

    @When("^I fill in an application form without a resume$")
    public void iFillInAnApplicationFormWithoutAResume() {
        positionSteps.navigateToApplyForm();
        positionSteps.fillAppicationWithDefaultContactData();
    }

    @When("^I click on apply now$")
    public void iClickOnApplyNow() {
        positionSteps.submitApplication();
    }

    @Then("^Validation error '(.*?)' is displayed$")
    public void validationErrorIsDisplayed(String expectedError) {
        positionSteps.verifyValidationErrorShown(expectedError);
    }
}
