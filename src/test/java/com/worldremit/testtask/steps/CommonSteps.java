package com.worldremit.testtask.steps;

import com.worldremit.testtask.utils.WebDriverUtils;

public class CommonSteps {
    public void navigateTo(String url) {
        WebDriverUtils.navigateTo(url);
    }
}
