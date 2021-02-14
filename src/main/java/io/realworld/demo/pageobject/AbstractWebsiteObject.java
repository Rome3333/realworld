package io.realworld.demo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.realworld.demo.driver.WebDriverProvider;
import io.realworld.demo.utils.webelement.WebElementWait;

public abstract class AbstractWebsiteObject {

    protected WebElementWait wait = new WebElementWait();

    public AbstractWebsiteObject() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebDriver getDriver() {
        return WebDriverProvider.getDriver();
    }

}
