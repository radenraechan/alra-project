package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RegisterPage extends PageObject {

    private By newUserButton() {
        return By.id("newUser");
    }
    private By firstNameField() {
        return By.id("firstname");
    }
    private By lastNameField() {
        return By.id("lastname");
    }
    private By usernameField() {
        return By.id("userName");
    }
    private By passwordField() {
        return By.id("password");
    }
    private By captchaButton() {
        return By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]");
    }
    private By registerButton() {
        return By.id("register");
    }

    // Scenario 2.1: Register (Positive)
    @Step
    public void clickNewUserButton() {
        $(newUserButton()).click();
    }

    @Step
    public boolean validateOnRegisterPage() {
        return $(registerButton()).isDisplayed();
    }

    @Step
    public void inputFirstName(String firstName) {
        $(firstNameField()).type(firstName);
    }

    @Step
    public void inputLastName(String lastName) {
        $(lastNameField()).type(lastName);
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
    public void clickValidateCaptcha() {
        $(captchaButton()).click();
    }

    @Step
    public void clickRegisterButton() {
//        getDriver().findElement(registerButton()).sendKeys(Keys.END);
        moveTo(registerButton());
        $(registerButton()).click();
    }
}
