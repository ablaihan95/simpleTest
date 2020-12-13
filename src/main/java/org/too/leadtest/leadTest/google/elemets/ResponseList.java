package org.too.leadtest.leadTest.google.elemets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ResponseList {

    private final SelenideElement adBox = $("div[aria-label= 'Реклама']"),
            mainBox = $("div#search");
    private final ElementsCollection adElementsList = adBox.$$(".uEierd"),
            mainElementsList = mainBox.$$("div.g"),
            fullResultList = $$x("//div[@class = 'uEierd' or @class = 'g']");

    public int getAllSizeOfList() {
        return adElementsList.size() + mainElementsList.size();
    }

    public SelenideElement getSelenideByText(String text) {
        return fullResultList.findBy(text(text));
    }

    public ElementsCollection getFullResultList() {
        return fullResultList;
    }
}
