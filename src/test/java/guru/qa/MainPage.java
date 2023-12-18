package guru.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement searchButton = $("[data-test='search-button']");
    private final SelenideElement searchField = $("[data-test='search-input']");
    private final SelenideElement deleteOne = $("#firstName");
    private final SelenideElement deleteTwo = $("#lastName");

    public MainPage pressSearchButton() {
        searchButton.click();

        return this;
    }

    public void fillSearchField(String name) {
        searchField.setValue(name)
                .pressEnter();
    }

    public void deleteOne(String value) {
        deleteOne.setValue(value);
    }
    public void deleteTwo(String value) {
        deleteTwo.setValue(value);
    }
}
