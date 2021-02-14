package io.realworld.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import io.realworld.demo.pageobject.component.ArticleComponent;
import io.realworld.demo.pageobject.page.HomePage;

public class FilterByTagTest extends BaseTest {

    private HomePage homePage = new HomePage();

    @Test
    public void applyFilterTest() {
        String tagName = "test";

        homePage.open();
        homePage.geTagListingComponent().clickOnTag(tagName);

        assertThat(homePage.getArticleListingComponent().getArticles()).extracting(ArticleComponent::getTagsText).as("Article doesn't have tag " + tagName).allMatch(tagsList -> tagsList.contains(tagName));

    }

    @Test
    public void applyFilterWhenAnotherFilterIsAlreadyAppliedTest() {
        String firstTagName = "test";
        String secondTagName = "SIDA";

        homePage.open();
        homePage.geTagListingComponent().clickOnTag(firstTagName);
        homePage.getArticleListingComponent().waitForArticlesToLoad();

        homePage.geTagListingComponent().clickOnTag(secondTagName);
        assertThat(homePage.getArticleListingComponent().getArticles()).extracting(ArticleComponent::getTagsText).as("Article doesn't have tag " + secondTagName).allMatch(tagsList -> tagsList.contains(secondTagName));

    }

}
