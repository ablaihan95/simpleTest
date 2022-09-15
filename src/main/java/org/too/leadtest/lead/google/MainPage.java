package org.too.leadtest.lead.google;

import org.too.leadtest.lead.google.elemets.SearchInput;

public class MainPage {
    private final SearchInput searchInput = new SearchInput();

    public void doSearchWithEnter(String text) {
        searchInput.setSearchValue(text).pressEnter();
    }
}