package guru.qa;

import io.qameta.allure.Link;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
@DisplayName("Модуль поиска")
public class HabrTests extends BaseTest {
    MainPage mP = new MainPage();
    @BeforeEach
    public void openMainPage() {
        step("Открытие главной страницы", () -> open("https://habr.com/ru/feed/"));
    }

    @Test
    @DisplayName("Поиск контента через строку поиска")
    @Link("https://qa.guru/pl/teach/control/lesson/view?id=305964703")
    @Tag("SMOKE")
    protected void searchForContentThroughTheSearchBarTest() {
        step("Открытие строки поиска", () -> mP.pressSearchButton());
        step("Ввод значения в строку поиска", () -> mP.fillSearchField("Тестирование"));
    }
}
