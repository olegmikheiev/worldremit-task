package com.worldremit.testtask.pages;

import com.worldremit.testtask.config.Config;
import com.worldremit.testtask.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CareersPage extends PageObject {
    private static final String PAGE_URL = "/careers";

    // TODO: Come up with better locator
    @FindBy(css = "div.header-section a")
    private WebElementFacade seeAllOurRoles;

    @FindBy(id = "department-select")
    private WebElementFacade departmentSelect;

    @FindBy(id = "office-select")
    private WebElementFacade officeSelect;

    @FindBy(css = "div.greenhouse-job-list div.jobs-grid")
    private WebElementFacade jobList;

    public void openPage() {
        WebDriverUtils.navigateTo(PAGE_URL);
        withTimeoutOf(Config.PAGE_LOAD_TIMEOUT)
                .waitFor(By.cssSelector("div.header-section"));
    }

    public boolean isOpen() {
        return getDriver().getCurrentUrl().contains(PAGE_URL);
    }

    public void clickSeeAllOurRoles() {
        WebDriverUtils.click(seeAllOurRoles);
    }

    public void selectDepartment(String department) {
        departmentSelect.selectByValue(department);
    }

    public void selectOffice(String office) {
        officeSelect.selectByValue(office);
    }

    public List<String> getOpenPositions() {
        if (!jobList.isPresent()) {
            log.error("Job list is not present on the page");
            return Collections.emptyList();
        }
        return jobList.thenFindAll(By.cssSelector("p.job-item-name"))
                .stream()
                .map(WebElementFacade::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void openPosition(String position) {
        final WebElementFacade positionElement = jobList.find(By.xpath(".//p[contains(), " + position + "]"));
        WebDriverUtils.click(positionElement);
    }
}
