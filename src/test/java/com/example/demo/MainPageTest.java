package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @DataProvider(name = "search-terms")
    public Object[][] dataProvFunc(){
        return new Object[][]{
                {"Selenium"},{"TestNg"}
        };
    }

    /**
     *
     */
    @BeforeClass(alwaysRun = true)
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    /**
     *
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        open("https://www.jetbrains.com/");
    }

    /**
     *
     * @param searchTerm
     */
    @Test(dataProvider ="search-terms", groups = { "search"})
    public void search(String searchTerm) {
        mainPage.searchForItem(searchTerm);
        Assert.assertEquals(mainPage.getSearchResultPopDownText(), searchTerm);
    }

    /**
     *
     */
    @Test(groups = {"navigation"})
    public void navigationToAllTools() {
        mainPage.clickSeeAllToolsBtn();
        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
    }
}
