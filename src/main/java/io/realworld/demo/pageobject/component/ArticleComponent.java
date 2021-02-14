package io.realworld.demo.pageobject.component;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.realworld.demo.pageobject.component.common.AbstractWebsiteComponent;

public class ArticleComponent extends AbstractWebsiteComponent {

    private By tags = By.cssSelector(".tag-list li");

    public List<String> getTagsText() {
        return getChildElements(tags).stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
