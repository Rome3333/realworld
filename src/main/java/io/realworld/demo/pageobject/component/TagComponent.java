package io.realworld.demo.pageobject.component;

import io.realworld.demo.pageobject.component.common.AbstractWebsiteComponent;

public class TagComponent extends AbstractWebsiteComponent {

    public String getText() {
        return getRootElement().getText();
    }

    public void click() {
        getRootElement().click();
    }
}
