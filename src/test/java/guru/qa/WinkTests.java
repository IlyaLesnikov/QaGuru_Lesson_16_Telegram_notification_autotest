package guru.qa;


import io.qameta.allure.Link;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;

public class WinkTests extends BaseTest {
    MainPage mP = new MainPage();
    @BeforeEach
    public void openMainPage() {
        open("https://wink.ru/");
    }

    @Tag("SMOKE")
    @ParameterizedTest
    @ValueSource(strings = {
            "Джентльмены",
            "Левша"
    })
    @DisplayName("Поиск контента через строку поиска")
    @Link("https://qa.guru/pl/teach/control/lesson/view?id=305964703")
    protected void searchForContentThroughTheSearchBar(String name) {
        mP.pressSearchButton()
                .fillSearchField(name);
    }
}
