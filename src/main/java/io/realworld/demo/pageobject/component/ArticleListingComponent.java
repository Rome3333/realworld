package io.realworld.demo.pageobject.component;

import static io.realworld.demo.pageobject.component.common.WebsiteComponentFactory.createComponents;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import io.realworld.demo.pageobject.component.common.AbstractWebsiteComponent;
import io.realworld.demo.utils.WaitingUtils;

public class ArticleListingComponent extends AbstractWebsiteComponent {

    private By articles = By.cssSelector("article-preview");

    @FindBy(css = "article-list")
    private WebElement rootElement;

    public ArticleListingComponent() {
        setRootElement(rootElement);
    }

    @Step
    public List<ArticleComponent> getArticles() {
        waitForArticlesToLoad();

        return createComponents(ArticleComponent.class, getChildElements(articles));
    }

    @Step
    public void waitForArticlesToLoad() {
        WaitingUtils.waitForCondition(visibilityOfAllElementsLocatedBy(articles));
    }

}
