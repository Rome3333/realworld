package io.realworld.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Step;
import io.realworld.demo.utils.browser.BrowserUtils;

public class BaseTest {

    @Step
    @BeforeMethod
    public void setUp() {
        cleanCookies();
        maximizeBrowser();
    }

    @Step
    @AfterMethod
    public void tearDown() {

    }

    private void cleanCookies() {
        BrowserUtils.deleteAllCookies();
    }

    private void maximizeBrowser() {
        BrowserUtils.maximizeWindow();
    }

}
