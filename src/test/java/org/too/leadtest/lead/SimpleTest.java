package org.too.leadtest.lead;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.too.leadtest.lead.google.MainPage;
import org.too.leadtest.lead.google.SearchPage;


public class SimpleTest extends BaseTest {
    @Disabled
    @Test
    @Description("Just simple test")
    @DisplayName("Первое задание - Тест для Яндекс почты")
    public void simpleTest() {
        step("Открыть страницу яндекс", () -> {
            open("https://yandex.kz");
        });
        step("Открыть страницу аторизации", () -> {
            $(byText("Почта")).click();
            switchTo().window("Авторизация");
        });
        step("Ввести логин", () -> {
            $(By.name("login")).setValue("testpowta");
            $("[type = submit]").click();
        });
        step("Ввести пароль", () -> {
            $(byName("passwd")).setValue("qwe123QWE");
            $("[type = submit]").click();
        });
        step("Проверить, что логин прошел успешно", () -> {
            $(".user-account__name").shouldHave(Condition.text("testpowta"));
        });
    }

    @Disabled
    @Test
    @Description("Test with little using PageObject")
    @DisplayName("Второе задание - тест для google поиска")
    public void simpleTest2() {
        open("https://google.com");
        new MainPage()
                .doSearchWithEnter("купить кофемашину bork c804");
        new SearchPage()
                .checkSizeGreaterThan(10)
                .checkResultHasText("sulpak.kz");
    }


    @Test
    @Description("Rest test for get request")
    @DisplayName("Третье задание - тест апи")
    public void rest() {
        given()
                .filter(new AllureRestAssured())
                .get("https://reqres.in/api/single_user")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .assertThat().body("data.name", hasItems("janet"));
        // тут нет janet для положительного теста попробуйте "cerulean"


    }
}