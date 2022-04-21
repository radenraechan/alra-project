package com.example.steps;

import com.example.app.pages.CalculatorPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculateStepDefinitions {

    CalculatorPage calculatorPage = new CalculatorPage();

    @Given("I am on calculator page")
    public void iAmOnCalculatorPage() {
        calculatorPage.validateOnCalculatorPage();
    }

    @When("I click {string}")
    public void iClick(String arg0) {
        calculatorPage.clickNumber(arg0);
    }

    @And("I click addition symbol")
    public void iClickAdditionSymbol() {
        calculatorPage.clickSymbolButton(" + ");
    }

    @Then("I get the result is {string}")
    public void iGetTheResultIs(String arg0) {
        calculatorPage.verifyResultDisplayed(arg0);
    }

    @And("I click substract symbol")
    public void iClickSubstractSymbol() {
        calculatorPage.clickSymbolButton(" - ");
    }

    @And("I click multiply symbol")
    public void iClickMultiplySymbol() {
        calculatorPage.clickSymbolButton(" x ");
    }

    @And("I click divide symbol")
    public void iClickDivideSymbol() {
        calculatorPage.clickSymbolButton(" ÷ ");
    }
}
