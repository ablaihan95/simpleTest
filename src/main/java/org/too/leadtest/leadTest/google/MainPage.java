package org.too.leadtest.leadTest.google;

import org.too.leadtest.leadTest.google.elemets.SearchInput;

public class MainPage {
    private final SearchInput searchInput = new SearchInput();

    public void doSearchWithEnter(String text) {
        searchInput.setSearchValue(text).pressEnter();
    }
}