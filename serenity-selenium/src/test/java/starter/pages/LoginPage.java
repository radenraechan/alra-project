package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.naming.directory.SearchResult;

public class LoginPage extends PageObject {

    private By loginHeader() {
        return By.xpath("//*[@id=\"app\"]/div/div/div[1]/div");
    }
    private By usernameField() {
        return By.id("userName");
    }
    private By passwordField() {
        return By.id("password");
    }
    private By loginButton() {
        return By.id("login");
    }
    private By errorMessage() {
        return By.id("name");
    }
    private By iconWarning(){
        return By.xpath("//input[@class='mr-sm-2 is-invalid form-control']");
    }
    private By interactionsText(){
        return By.xpath("//div[text() = 'Interactions']");
    }

    // Scenario 1.1: Login (Positive)
    @Step
    public boolean headerAppears() {
        return $(loginHeader()).isDisplayed();
    }

    @Step
    public boolean headerTextEqual() {
        return $(loginHeader()).getText().equals("Login");
    }

    @Step
    public boolean validateOnLoginPage() {
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username) {
        $(usernameField()).type(username);
    }

    @Step
    public void inputPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void scrollTo() throws InterruptedException {
        SerenityActions actions = new SerenityActions(getDriver());
        actions.moveToElement($(interactionsText())).perform();
        // getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(3000);
    }

    @Step
    public void clickLoginButton() {
        $(loginButton()).click();
    }

    // Scenario 1.2: Login (Negative)
    @Step
    public void inputInvalidPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public boolean errorMessageAppears() {
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean errorMessageEquals(String errorMessage) {
        return $(errorMessage()).getText().equals(errorMessage);
    }

    // Scenario 1.3: Login (Negative)
    @Step
    public void inputInvalidUsername(String username) {
        $(usernameField()).type(username);
    }

    // Scenario DDT
    @Step
    public boolean verifyIconWarningAppears(){
        return $(iconWarning()).isDisplayed();
    }
}
