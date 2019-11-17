package com.worldremit.testtask.steps;

import com.worldremit.testtask.pages.PositionPage;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PositionSteps {
    @Page
    private PositionPage positionPage;

    @Step
    public void verifyPositionPageIsOpen() {
        assertThat(positionPage.isOpen())
                .as("Position page is not open")
                .isTrue();
    }

    @Step
    public void verifyPositionTitleMatches(String expectedTitle) {
        assertThat(positionPage.getPositionTitle())
                .as("Position title verification failed")
                .contains(expectedTitle);
    }

    @Step
    public void navigateToApplyForm() {
        log.info("Navigating to application form");
        positionPage.navigateToApplyForm();
    }

    @Step
    public void fillAppicationWithDefaultContactData() {
        log.info("Filling in application form...");
        positionPage.setFirstNameInput("Oleg");
        positionPage.setLastName("Mikheiev");
        positionPage.setEmail("oleg.miky@gmail.com");
        log.info("Application form has been filled");
    }

    @Step
    public void submitApplication() {
        log.info("Submitting an application...");
        positionPage.submitApplication();
        log.info("Application has been submitted");
    }

    @Step
    public void verifyValidationErrorShown(String expectedError) {
        log.info("Varifying that validation error '{}' is shown", expectedError);
        assertThat(positionPage.getValidationErrors())
                .as("Expected validation error is not visible")
                .contains(expectedError);
    }
}
