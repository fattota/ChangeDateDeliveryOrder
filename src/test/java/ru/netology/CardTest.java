package ru.netology;

import org.openqa.selenium.Keys;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.data.RegistrationInfo;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataGenerator.generateDate;

public class CardTest {
    RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");

    @Test
    public void shouldSendCompletedFormAndChangeDate() {
        String newDate = generateDate(5);

        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue(info.getAddress());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(info.getDate());
        $x("//*[@name='name']").setValue(info.getName());
        $x("//*[@name='phone']").setValue(info.getPhoneNumber());
        $(".checkbox__box").click();
        $$(".button").find(exactText("Запланировать")).click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + info.getDate()), Duration.ofSeconds(15)).shouldBe(visible);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(newDate);
        $$(".button").find(exactText("Запланировать")).click();
        $$(".button__text").find(exactText("Перепланировать")).click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + newDate), Duration.ofSeconds(15)).shouldBe(visible);
    }
}

