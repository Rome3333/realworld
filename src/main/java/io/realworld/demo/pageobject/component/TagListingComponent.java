package io.realworld.demo.pageobject.component;

import static io.realworld.demo.pageobject.component.common.WebsiteComponentFactory.createComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import io.realworld.demo.pageobject.component.common.AbstractWebsiteComponent;

public class TagListingComponent extends AbstractWebsiteComponent {

    public static final String CLASS_FOR_HIDDEN_ELEMENT = "ng-hide";

    private By tags = By.cssSelector(".tag-default");

    @FindBy(css = ".sidebar .tag-list")
    private WebElement rootElement;


    public TagListingComponent() {
        setRootElement(rootElement);
    }

    @Step
    public void clickOnTag(String tagName) {
        getTagByName(tagName).click();
    }

    public TagComponent getTagByName(String tagName) {
        waitForTagsToBeDisaplyed();

        return getTagElements().stream().filter(tag -> tag.getText().equalsIgnoreCase(tagName)).findFirst().orElseThrow(() -> new IllegalStateException("There is no tag with name " + tagName));
    }

    private void waitForTagsToBeDisaplyed() {
        wait.forClassAttributeToNotContain(rootElement, CLASS_FOR_HIDDEN_ELEMENT);
    }

    private List<TagComponent> getTagElements() {
        return createComponents(TagComponent.class, getChildElements(tags));
    }

}
