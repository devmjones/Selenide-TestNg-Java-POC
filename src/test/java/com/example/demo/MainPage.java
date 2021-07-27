package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    HelperMethods helperMethods = new HelperMethods();

    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement searchField = $("[data-test='search-input']");
    public SelenideElement searchResultPopDown = $("span.quick-search__results-query");

    public void searchForItem(String item){
        this.searchButton.shouldBe(Condition.visible);
        this.searchButton.click();
        this.searchField.shouldBe(Condition.visible);
        this.searchField.sendKeys(item);
    }

    public String getSearchResultPopDownText(){
        return this.searchResultPopDown.getText();
    }

    public void clickSeeAllToolsBtn(){
        this.seeAllToolsButton.click();
    }
}
