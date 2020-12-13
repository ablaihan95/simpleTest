package org.too.leadtest.leadTest.google.elemets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getSelectedRadio;

public class SearchInput {
    private final SelenideElement searchInput;
    public SearchInput() {
        this.searchInput = $(By.name("q"));
    }

    public SelenideElement setSearchValue(String searchText) {
        return searchInput.setValue(searchText);
    }


}
