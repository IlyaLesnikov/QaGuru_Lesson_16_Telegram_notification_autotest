package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.AssertComponents.AssertComponents;
import guru.qa.pages.MainPage;
import guru.qa.helpers.Attach;
import guru.qa.pages.ResultSearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты на покрытие функционала поисковой строки")
public class EbayTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    AssertComponents assertComponents = new AssertComponents();
    @BeforeEach
    protected void allureStepsAndOpenBrowser() {
        step("Открытие главной страницы", () -> open("https://www.ebay.com/"));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    protected void allureScreenshotAndVideoAndLoggs() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "New Balance 993", "New Balance 991"
    })

    @Tag("SMOKE")
    @DisplayName("Поиск товара по его названию через строку поиска")
    protected void searchForAProductByItsNameThroughTheSearchBar(String productName) {
        step("Заполнение строки поиска значением и нажатие кнопки 'Найти'", () -> {mainPage.fillInTheSearchField(productName);
        mainPage.clickingOnTheSearchButton();
        });
        step("Добавление товара в избранное", () -> resultSearchPage.addingAnItemToFavorites());
        step("Проверка приветствия на веб-форме 'Авторизация'", () -> assertComponents.assertText("Здравствуйте!"));
    }
}
