package io.realworld.demo.pageobject.component.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.realworld.demo.pageobject.AbstractWebsiteObject;

public abstract class AbstractWebsiteComponent extends AbstractWebsiteObject {

    private WebElement rootElement;

    protected WebElement getChildElement(By dropDownArrow) {
        return waitForLoad().findElement(dropDownArrow);
    }

    protected List<WebElement> getChildElements(By dropDownArrow) {
        return waitForLoad().findElements(dropDownArrow);
    }

    protected WebElement getRootElement() {
        if (rootElement.toString().contains("rootElement")) {
            throw new IllegalStateException(
                    "Fragment's root element is not initialized! Set it via setRootElement during fragment creation (in constructor or using WebComponentFactory)");
        }
        return rootElement;
    }

    protected void setRootElement(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    protected WebElement waitForLoad() {
        return wait.forAppear(getRootElement());
    }

}
