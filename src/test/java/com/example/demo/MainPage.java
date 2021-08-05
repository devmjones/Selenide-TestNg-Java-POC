package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    HelperMethods helperMethods = new HelperMethods();

    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement searchField = $("[data-test='search-input']");
    public SelenideElement searchResultPopDown = $("span.quick-search__results-query");

    /**
     * Searches for the passed in item
     * @param item
     * @author Devon Jones
     */
    public void searchForItem(String item){
        this.searchButton.shouldBe(Condition.visible);
        this.searchButton.click();
        this.searchField.shouldBe(Condition.visible);
        this.searchField.sendKeys(item);
    }

    /**
     * Returns the text in the search box dropdown
     * @return text
     * @author Devon Jones
     */
    public String getSearchResultPopDownText(){
        return this.searchResultPopDown.getText();
    }


    public void clickSeeAllToolsBtn(){
        this.seeAllToolsButton.click();
    }
}
