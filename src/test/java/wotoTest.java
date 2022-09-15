import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class wotoTest {
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
