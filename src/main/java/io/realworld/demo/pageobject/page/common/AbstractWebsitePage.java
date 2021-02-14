package io.realworld.demo.pageobject.page.common;

import io.qameta.allure.Step;
import io.realworld.demo.pageobject.AbstractWebsiteObject;
import io.realworld.demo.utils.properties.ConfigurationProperties;

public abstract class AbstractWebsitePage extends AbstractWebsiteObject {

    @Step
    public void open() {
        String pageUrl = ConfigurationProperties.getTargetWebsiteUrl() + getPageUrl();
        getDriver().get(pageUrl);
    }

    protected abstract String getPageUrl();

}
