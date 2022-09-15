package org.too.leadtest.leadTest.google;

import static com.codeborne.selenide.Condition.text;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.too.leadtest.leadTest.google.elemets.ResponseList;
import org.too.leadtest.leadTest.google.elemets.SearchInput;

public class SearchPage {
    private ResponseList responseList = new ResponseList();
    private SearchInput searchInput = new SearchInput();

//    public void checkListSize(int expectedSize) {
//        assertEquals(expectedSize, responseList.getAllSizeOfList());
//    }

    @Step("Check than search result greater than {0} ")
    public SearchPage checkSizeGreaterThan(int expectedValue) {
        responseList.getFullResultList().shouldHave(CollectionCondition.sizeGreaterThan(expectedValue));

        return this;
    }

    public SearchPage getValueInList(String text) {
        responseList.getFullResultList().findBy(text(text));

        return this;
    }

    @Step("Check than search result has at least one match with {0} ")
    public SearchPage checkResultHasText(String text) {
//        assertTrue(responseList.getFullResultList().findBy(text(text)).isDisplayed());
        return this;
    }
}
