package io.realworld.demo.pageobject.page;

import static io.realworld.demo.pageobject.component.common.WebsiteComponentFactory.createComponent;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import io.realworld.demo.pageobject.component.ArticleListingComponent;
import io.realworld.demo.pageobject.component.TagListingComponent;
import io.realworld.demo.pageobject.page.common.AbstractWebsitePage;

public class HomePage extends AbstractWebsitePage {

    private static final String PAGE_URL = EMPTY;

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }

    public TagListingComponent geTagListingComponent() {
        return createComponent(TagListingComponent.class);
    }

    public ArticleListingComponent getArticleListingComponent() {
        return createComponent(ArticleListingComponent.class);
    }

}
