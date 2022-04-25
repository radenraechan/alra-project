package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class BookStorePage extends PageObject {

    private By bookstoreHeader() {
        return By.xpath("//*[@id=\"app\"]/div/div/div[1]/div");
    }
    private By loginButton() {
        return By.id("login");
    }
    private By adsButton() {
        return By.xpath("//*[@id=\"close-fixedban\"]/img");
    }
    private By searchField() {
        return By.id("searchBox");
    }
    private By searchResult() {
        return By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[4]");
    }

    // Scenario 1 dan 2
    @Step
    public void openUrl() {
        openAt("/books");
//        $(adsButton()).click();
    }

    @Step
    public boolean headerAppears() {
        return $(bookstoreHeader()).isDisplayed();
    }

    @Step
    public boolean headerTextEqual() {
        return $(bookstoreHeader()).getText().equals("Book Store");
    }

    @Step
    public boolean validateOnBookStorePage() {
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void clickLoginButton() {
        $(loginButton()).click();
    }

    // Scenario 3.1: Search (Positive)
    @Step
    public void inputText(String text) {
        $(searchField()).type(text);
    }

    @Step
    public void foundTheBooks() {
        $(searchResult()).type();
    }
}
