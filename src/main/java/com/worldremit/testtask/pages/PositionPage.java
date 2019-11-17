package com.worldremit.testtask.pages;

import com.worldremit.testtask.utils.WebDriverUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class PositionPage extends PageObject {
    @FindBy(id = "careers-job-page")
    private WebElementFacade thisPage;

    @FindBy(css = "div.job-content-header h1")
    private WebElementFacade positionHeader;

    @FindBy(css = "div.application-form")
    private WebElementFacade applicationForm;

    @FindBy(css = "div.job-content-header a")
    private WebElementFacade applyNowButton;

    @FindBy(id = "First_Name")
    private WebElementFacade firstNameInput;

    @FindBy(id = "Last_Name")
    private WebElementFacade lastNameInput;

    @FindBy(id = "Email")
    private WebElementFacade emailInput;

    @FindBy(css = "div.application-form > input[type='submit']")
    private WebElementFacade submitApplicationButton;

    public boolean isOpen() {
        return thisPage.isPresent();
    }

    public String getPositionTitle() {
        return positionHeader.getText().trim();
    }

    public void navigateToApplyForm() {
        WebDriverUtils.click(applyNowButton);
    }

    public void setFirstNameInput(String name) {
        firstNameInput.type(name);
    }

    public void setLastName(String lastName) {
        lastNameInput.type(lastName);
    }

    public void setEmail(String email) {
        emailInput.type(email);
    }

    public void submitApplication() {
        WebDriverUtils.click(submitApplicationButton);
    }

    public List<String> getValidationErrors() {
        WebDriverUtils.scrollIntoView(applicationForm);
        return findAll(By.cssSelector("span.field-validation-error")).stream()
                .filter(WebElementState::isCurrentlyVisible)
                .map(e -> e.getAttribute("data-message-error"))
                .collect(Collectors.toList());
    }
}
