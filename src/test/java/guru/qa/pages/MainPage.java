package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement searchField = $("[class*='autocomplete-input']");
    private final SelenideElement searchButton = $("[value='Search']");
    public MainPage fillInTheSearchField(String productName) {
        searchField.setValue(productName);

        return this;
    }

    public void clickingOnTheSearchButton() {
        searchButton.click();
    }
}
