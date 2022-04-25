package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.BookStorePage;
import starter.pages.ProfilePage;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;

public class RegisterSteps {

    @Steps
    BookStorePage bookStorePage;

    @Steps
    LoginPage loginPage;

    @Steps
    RegisterPage registerPage;

    @Steps
    ProfilePage profilePage;

    // Scenario 2.1: Register (Positive)
    @When("click new user button")
    public void clickNewUserButton() {
        registerPage.clickNewUserButton();
        registerPage.validateOnRegisterPage();
    }

    @And("input valid first name")
    public void inputValidFirstName() {
        registerPage.inputFirstName("First");
    }

    @And("input valid last name")
    public void inputValidLastName() {
        registerPage.inputLastName("Last");
    }

    @And("click validate captcha")
    public void clickValidateCaptcha() {
        registerPage.clickValidateCaptcha();
    }

    @And("click register button")
    public void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }
}
