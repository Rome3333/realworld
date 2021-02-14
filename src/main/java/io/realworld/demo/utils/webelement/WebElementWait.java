package io.realworld.demo.utils.webelement;

import static io.realworld.demo.utils.WaitingUtils.waitForCondition;
import static io.realworld.demo.utils.properties.TimeoutConstants.WEB_ELEMENT_VISIBILITY_TIMEOUT;
import static io.realworld.demo.utils.webelement.WebElementAttributeConstants.CLASS_ATTRIBUTE;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebElementWait {

    public WebElement forAppear(WebElement element) {
        return forAppear(element, WEB_ELEMENT_VISIBILITY_TIMEOUT);
    }

    public WebElement forAppear(WebElement element, int timeout) {
        return waitForCondition(ExpectedConditions.visibilityOf(element), timeout);
    }

    public void forClassAttributeToNotContain(WebElement element, String expectedValue) {
        waitForCondition(not(attributeContains(element, CLASS_ATTRIBUTE, expectedValue)));
    }
}
