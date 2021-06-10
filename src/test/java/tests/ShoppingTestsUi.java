package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ShoppingTestsUi extends TestBase {


    @Test
    void addAndBuyUITest() {
        step("Open site", () -> {
        open("https://buy-in-10-seconds.company.site/");
        });
        step("Shopping Cart", () -> {
        $(".grid-product__shadow-inner").click();
        $x("//button[contains(.,'В корзину')]").click();
        $x("//button[contains(.,'Корзина')]").click();
        });
        step("Registration form", () -> {
        $("#ec-cart-email-input").sendKeys("two@1.ru");
        $("#form-control__checkbox--agree").click();
        $(".form-control__loader").click();
        $("#ec-country").click();
        $(byText("Перу")).click();
        $("#ec-full-name").sendKeys("Alex");
        $("#ec-phone").sendKeys("8800");
        $("#ec-address-line1").sendKeys("Street");
        $("#ec-city-list").sendKeys("City");
        $("#ec-postal-code").sendKeys("191919");
        $(".form-control__select").click();
        $(byText("Ica")).click();
        $(".form-control__loader").click();
        });
        step("Verify successful buy", () -> {
        $(".ec-header-h1").shouldHave(text("Спасибо за заказ! "));
        });
    }
}
