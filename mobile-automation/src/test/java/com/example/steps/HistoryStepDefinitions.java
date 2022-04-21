package com.example.steps;

import com.example.app.pages.CalculatorPage;
import com.example.app.pages.HistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HistoryStepDefinitions {

    CalculatorPage calculatorPage = new CalculatorPage();
    HistoryPage historyPage = new HistoryPage();

    @When("I click history button")
    public void iClickHistoryButton() {
        calculatorPage.clickHistoryButton();
    }

    @Then("I get the result of history")
    public void iGetTheResultOfHistory() {
        historyPage.validateOnHistoryPage();
    }

    @When("I click delete button")
    public void iClickDeleteButton() {
        historyPage.clickDeleteButton();
    }

    @Then("I get the result after delete history")
    public void iGetTheResultAfterDeleteHistory() {
        calculatorPage.validateOnCalculatorPage();
    }
}
