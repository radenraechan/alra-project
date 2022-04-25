package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.ProfilePage;
import starter.pages.BookStorePage;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;

public class LoginSteps {

    @Steps
    BookStorePage bookStorePage;

    @Steps
    LoginPage loginPage;

    @Steps
    RegisterPage registerPage;

    @Steps
    ProfilePage profilePage;

    // Scenario 1.1: Login (Positive)
    @Given("I am on the bookstore page")
    public void iAmOnTheBookstorePage() {
        bookStorePage.openUrl();
        bookStorePage.headerAppears();
        bookStorePage.headerTextEqual();
        bookStorePage.validateOnBookStorePage();
    }

    @And("I click login button")
    public void iClickLoginButton() {
        bookStorePage.clickLoginButton();
        loginPage.headerAppears();
        loginPage.headerTextEqual();
        loginPage.validateOnLoginPage();
    }

    @When("input valid username")
    public void inputValidUsername() {
        loginPage.inputUsername("string");
        registerPage.inputUsername("string123");
    }

    @And("input valid password")
    public void inputValidPassword() {
        loginPage.inputPassword("String1*");
        registerPage.inputPassword("String123*");
    }

    @And("click login button")
    public void clickLoginButton() throws InterruptedException {
        loginPage.scrollTo();
        loginPage.clickLoginButton();
    }

    @Then("I will direct to profile page")
    public void iWillDirectToProfilePage() {
        profilePage.headerAppears();
        profilePage.headerTextEqual();
    }

    // Scenario DDT
    @When("I input {string} username")
    public void iInputUsername(String userName) {
        loginPage.inputUsername(userName);
    }

    @And("I input {string} password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Then("I get the {string}")
    public void iGetThe(String result) {
        if(result.equals("icon warning")){
            loginPage.verifyIconWarningAppears();
        } else if (result.equals("page profile")){
            profilePage.headerAppears();
            profilePage.headerTextEqual();
        } else {
            loginPage.errorMessageAppears();
            loginPage.errorMessageEquals(result);
        }
    }

    // Scenario 1.2: Login (Negative)
    @And("input invalid password")
    public void inputInvalidPassword() {
        loginPage.inputInvalidPassword("string");
    }

    @Then("Page will show an error message {string}")
    public void pageWillShowAnErrorMessage(String arg0) {
        loginPage.errorMessageAppears();
        loginPage.errorMessageEquals(arg0);
    }

    // Scenario 1.3: Login (Negative)
    @And("input invalid username")
    public void inputInvalidUsername() {
        loginPage.inputInvalidUsername("string123");
    }
}
