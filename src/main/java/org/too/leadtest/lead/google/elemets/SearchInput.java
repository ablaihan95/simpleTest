package org.too.leadtest.lead.google.elemets;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchInput {
    private final SelenideElement searchInput;
    public SearchInput() {
        this.searchInput = $(By.name("q"));
    }

    public SelenideElement setSearchValue(String searchText) {
        return searchInput.setValue(searchText);
    }


}
