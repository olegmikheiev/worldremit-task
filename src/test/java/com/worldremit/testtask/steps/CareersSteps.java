package com.worldremit.testtask.steps;

import com.worldremit.testtask.pages.CareersPage;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CareersSteps {
    @Page
    private CareersPage careersPage;

    @Step
    public void openCareersPage() {
        if (!careersPage.isOpen()) {
            log.info("Opening Careers page");
            careersPage.openPage();
        }
    }

    @Step
    public void verifyCareersPageOpen() {
        assertThat(careersPage.isOpen())
                .as("Careers page is not currently open")
                .isTrue();
        log.info("Careers page is open");
    }

    @Step
    public void goToOpenPositionsForm() {
        log.info("Navigating to open positions form");
        careersPage.clickSeeAllOurRoles();
    }

    @Step
    public void selectDepartment(String department) {
        log.info("Selecting a department '{}'...", department);
        careersPage.selectDepartment(department);
        log.info("Department has been selected");
    }

    @Step
    public void selectOffice(String office) {
        log.info("Selecting an office '{}'...", office);
        careersPage.selectOffice(office);
        log.info("Office has been selected");
    }

    @Step
    public void findPositionFor(String role) {
        final String position = findPositionContains(role);
        assertThat(position)
                .as("Position with role '%s' was not found", role)
                .isNotNull().isNotEmpty();
    }

    @Step
    public void openPosition(String role) {
        final String position = findPositionContains(role);
        careersPage.openPosition(position);
    }

    private String findPositionContains(String role) {
        log.info("Looking for position containing '{}'...", role);
        List<String> positions = careersPage.getOpenPositions();
        assertThat(positions)
                .as("No positions found")
                .isNotEmpty();
        final String position = positions.stream()
                .filter(p -> p.contains(role))
                .findFirst()
                .orElse(null);
        log.info("Found position '{}'", position);
        return position;
    }
}
