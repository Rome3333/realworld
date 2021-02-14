package io.realworld.demo.driver;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

public class WebDriverProvider {

    private static final WebDriverFactory WEB_DRIVER_FACTORY = new WebDriverFactory();
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return Optional.ofNullable(DRIVER.get()).orElseGet(() -> {
            DRIVER.set(WEB_DRIVER_FACTORY.getDriver());
            return DRIVER.get();
        });
    }

}
