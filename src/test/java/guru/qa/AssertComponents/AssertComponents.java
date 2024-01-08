package guru.qa.AssertComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AssertComponents {
    private final SelenideElement helloTextElement = $("[class*='signin-intro']");

    public void assertText(String helloText) {
        helloTextElement.shouldHave(text(helloText));
    }
}
