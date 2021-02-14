package io.realworld.demo.utils.browser;

import org.openqa.selenium.WebDriver;

import io.realworld.demo.driver.WebDriverProvider;

public class BrowserUtils {

    public static void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    private static WebDriver getDriver() {
        return WebDriverProvider.getDriver();
    }

}
