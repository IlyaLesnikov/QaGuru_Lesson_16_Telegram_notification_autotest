package guru.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement searchButton = $("[test-id='mnav_search']");
    private final SelenideElement searchField = $("[class*='input-text']");
    public MainPage pressSearchButton() {
        searchButton.click();

        return this;
    }

    public void fillSearchField(String name) {
        searchField.setValue(name)
                .pressEnter();
    }
}
