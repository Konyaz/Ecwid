package tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RestApi {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://buy-in-10-seconds.company.site/";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://buy-in-10-seconds.company.site/";
    }

    @Test
    public void addItemToCartAsNewUserTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("{\"eventName\":\"PAGE_VIEW\",\"entityType\":\"PRODUCT\",\"productIds\":[351702553],\"price\":0,\"currency\":\"USD\",\"storeId\":59965088,\"siteUrl\":\"https://buy-in-10-seconds.company.site\",\"cartId\":\"ADFF7DAC-A019-4C28-BB15-D8DBF8897D47\",\"fullUrl\":\"https://buy-in-10-seconds.company.site/Tovar-1-p351702553\",\"visitorId\":\"1623237115862153679\",\"sessionId\":\"1623339168137949611\"}")
                .when()
                .post("https://ecomm.events/register")
                .then()
                .statusCode(200)
                .log().body()
                .body("success", is(true))
                .body("updatetopcartsectionhtml", is("(1)"));
    }
}