package io.realworld.demo.utils;

import static io.realworld.demo.driver.WebDriverProvider.getDriver;
import static io.realworld.demo.utils.properties.TimeoutConstants.LONG_TIMEOUT;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingUtils {

    public static <T> T waitForCondition(ExpectedCondition<T> userCondition) {
        return getWebDriverWait().until(userCondition);
    }

    public static <T> T waitForCondition(ExpectedCondition<T> userCondition, int timeout) {
        return getWebDriverWait(timeout).until(userCondition);
    }

    private static WebDriverWait getWebDriverWait(long timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    private static WebDriverWait getWebDriverWait() {
        return getWebDriverWait(LONG_TIMEOUT);
    }
}
