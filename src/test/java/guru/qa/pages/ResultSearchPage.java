package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ResultSearchPage {
    private final SelenideElement likeButton = $("[class*='watchheart-icon']");

    public void addingAnItemToFavorites() {
        likeButton.click();
    }
}
