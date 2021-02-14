package io.realworld.demo.driver;

import static io.realworld.demo.utils.properties.ConfigurationConstants.CHROME_DRIVER_WINDOWS_PATH;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public WebDriver getDriver() {
        WebDriver driver = createWebDriver();
        Runtime.getRuntime().addShutdownHook(new Thread(closeDriverRunnable(driver)));
        return driver;
    }

    private WebDriver createWebDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(CHROME_DRIVER_WINDOWS_PATH)).usingAnyFreePort().build();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(service, options);
    }

    private static Runnable closeDriverRunnable(WebDriver driver) {
        return driver::quit;
    }

}
