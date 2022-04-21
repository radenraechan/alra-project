package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.bookstore.*;

public class bookstoreStep {
    @Steps
    Post post;

    @Steps
    DeleteWithUserId deleteWithUserId;

    @Steps
    Get get;

    @Steps
    Delete delete;

    @Steps
    Put put;

    // Scenario 1.1: POST (Positive)
    @Given("I set an endpoint for POST get book")
    public void setAnEndpointForPOSTGetBook() {
        post.setPostEndpoint();
    }

    @When("I request POST detail book")
    public void requestPOSTDetailBook() {
        post.requestPostDetailBook();
    }

    @Then("I validate the status code is 201")
    public void validateTheStatusCodeIs201() {
        post.validateStatusCode(201);
    }

    @And("validate the data detail book")
    public void validateTheDataDetailBook() {
        post.validateDataDetail();
        get.validateDataDetail();
    }

    // Scenario 1.2: POST (Negative)
    @When("I request POST detail book without authorized")
    public void requestPOSTDetailBookWithoutAuthorized() {
        post.requestPostDetailBookWithoutAuthorized();
    }

    @Then("I validate the status code is 401")
    public void validateTheStatusCodeIs401() {
        post.validateStatusCode(401);
        delete.validateStatusCode(401);
        deleteWithUserId.validateStatusCode(401);
        // put.validateStatusCodeIs401();
    }

    @And("validate the data detail after failed get book without authorized")
    public void validateTheDataDetailBookAfterFailedGetBookWithoutAuthorized() {
        post.validateDataDetailAfterFailedGetBookWithoutAuthorized();
    }

    // Scenario 1.3: POST (Negative)
    @When("I request POST detail book with invalid input userId")
    public void requestPOSTDetailBookWithInvalidInputUserId() {
        post.requestPostDetailBookWithInvalidInputUserId();
    }

    @And("validate the data detail after failed get book with invalid input userId")
    public void validateTheDataDetailBookAfterFailedGetBookWithInvalidInputUserId() {
        post.validateDataDetailAfterFailedGetBookWithInvalidInputUserId();
    }

    // Scenario 1.4: POST (Negative)
    @When("I request POST detail book with invalid input ISBN")
    public void requestPOSTDetailBookWithInvalidInputISBN() {
        post.requestPostDetailBookWithInvalidInputISBN();
    }

    @Then("I validate the status code is 400")
    public void validateTheStatusCodeIs400() {
        post.validateStatusCode(400);
        get.validateStatusCode(400);
        delete.validateStatusCode(400);
        // put.validateStatusCodeIs400();
    }

    @And("validate the data detail after failed get book with invalid input ISBN")
    public void validateTheDataDetailBookAfterFailedGetBookWithInvalidInputISBN() {
        post.validateDataDetailAfterFailedGetBookWithInvalidInputISBN();
    }

    // Scenario 2.1: DELETE (Positive)
    @Given("I set an endpoint for DELETE books")
    public void setAnEndpointForDELETEBooks() {
        deleteWithUserId.setAnEndpointForDelete();
    }

    @When("I request DELETE books")
    public void requestDELETEBooks() {
        deleteWithUserId.requestDeleteBooks();
    }

    @Then("I validate the status code is 204")
    public void validateTheStatusCodeIs204() {
        deleteWithUserId.validateStatusCode(204);
    }

    @And("validate the data detail after delete books")
    public void validateTheDataDetailAfterDeleteBooks() {
        deleteWithUserId.validateDataDetailAfterDeleteBooks();
    }

    // Scenario 2.2: DELETE (Negative)
    @When("I request DELETE books without authorized")
    public void requestDELETEBooksWithoutAuthorized() {
        deleteWithUserId.requestDeleteBooksWithoutAuthorized();
    }

    @And("validate the data detail after failed delete books without authorized")
    public void validateTheDataDetailAfterFailedDeleteBooksWithoutAuthorized() {
        deleteWithUserId.validateDataDetailAfterFailedDeleteBooksWithoutAuthorized();
    }

    // Scenario 2.3: DELETE (Negative)
    @When("I request DELETE books with invalid input userId")
    public void requestDELETEBooksWithInvalidInputUserId() {
        deleteWithUserId.requestDeleteBooksWithInvalidUserId();
    }

    @And("validate the data detail after failed delete books with invalid input userId")
    public void validateTheDataDetailAfterFailedDeleteBooksWithInvalidInputUserId() {
        deleteWithUserId.validateDataDetailAfterFailedDeleteBooksWithInvalidUserId();
    }

    // Scenario 3.1: GET (Positive)
    @Given("I set an endpoint for GET detail book")
    public void setAnEndpointForGETDetailBook() {
        get.setAnEndpointForGet("9781449325862");
    }

    @When("I request GET detail book")
    public void requestGETDetailBook() {
        get.requestGetDetailBook();
    }

    @Then("I validate the status code is 200")
    public void validateTheStatusCodeIs200() {
        get.validateStatusCode(200);
        // put.validateStatusCodeIs200();
    }

    // Scenario 3.2: GET (Negative)
    @Given("I set an endpoint for GET detail book with input invalid ISBN")
    public void setAnEndpointForGETDetailBookWithInputInvalidISBN() {
        get.setAnEndpointForGet("9781449325862a");
    }

    @When("I request GET detail book with input invalid ISBN")
    public void requestGETDetailBookWithInputInvalidISBN() {
        get.requestGetDetailBookWithInputInvalidISBN();
    }

    @And("validate the data detail book with input invalid ISBN")
    public void validateTheDataDetailBookWithInputInvalidISBN() {
        get.validateDataDetailWithInputInvalidISBN();
    }

    // Scenario 3.3: GET (Negative)
    @Given("I set an endpoint for GET detail book with input null ISBN")
    public void setAnEndpointForGETDetailBookWithInputNullISBN() {
        get.setAnEndpointForGet("");
    }

    @When("I request GET detail book with input null ISBN")
    public void requestGETDetailBookWithInputNullISBN() {
        get.requestGetDetailBookWithInputNullISBN();
    }

    @And("validate the data detail book with input null ISBN")
    public void validateTheDataDetailBookWithInputNullISBN() {
        get.validateDataDetailWithInputNullISBN();
    }

    // Scenario 4.1: DELETE (Positive)
    @Given("I set an endpoint for DELETE book")
    public void setAnEndpointForDELETEBook() {
        delete.setAnEndpointForDelete();
    }

    @When("I request DELETE book")
    public void requestDELETEBook() {
        delete.requestDeleteBook();
    }

    @And("validate the data detail after delete book")
    public void validateTheDataDetailAfterDeleteBook() {
        delete.validateDataDetailAfterDeleteBook();
    }

    // Scenario 4.2: DELETE (Negative)
    @When("I request DELETE book without authorized")
    public void requestDELETEBookWithoutAuthorized() {
        delete.requestDeleteBookWithoutAuthorized();
    }

    @And("validate the data detail after failed delete book without authorized")
    public void validateTheDataDetailAfterFailedDeleteBookWithoutAuthorized() {
        delete.validateDataDetailAfterFailedDeleteBookWithoutAuthorized();
    }

    // Scenario 4.3: DELETE (Negative)
    @When("I request DELETE book with invalid userId")
    public void requestDELETEBookWithInvalidUserId() {
        delete.requestDeleteBookWithInvalidUserId();
    }

    @And("validate the data detail after failed delete book with invalid userId")
    public void validateTheDataDetailAfterFailedDeleteBookWithInvalidUserId() {
        delete.validateDataDetailAfterFailedDeleteBookWithInvalidUserId();
    }

    // Scenario 4.4: DELETE (Negative)
    @When("I request DELETE book with invalid ISBN")
    public void requestDELETEBookWithInvalidISBN() {
        delete.requestDeleteBookWithInvalidISBN();
    }

    @And("validate the data detail after failed delete book with invalid ISBN")
    public void validateTheDataDetailAfterFailedDeleteBookWithInvalidISBN() {
        delete.validateDataDetailAfterFailedDeleteBookWithInvalidISBN();
    }

    // Scenario 5.1: PUT (Positive)
    @Given("I set an endpoint for PUT detail books")
    public void setAnEndpointForPUTDetailBooks() {
        put.setPostEndpoint();
    }

    @When("I request PUT detail books")
    public void requestGETDetailBooks() {
        put.requestPUTDetailBooks();
    }

    @And("validate the data detail books")
    public void validateTheDataDetailBooks(){
        put.validateDataDetail();
    }

    // Scenario 5.2: PUT (Negative)
    @When("I request PUT detail books without authorized")
    public void requestGETDetailBooksWithoutAuthorized() {
        put.requestPUTDetailBooksWithoutAuthorized();
    }

    @And("validate the data detail books without authorized")
    public void validateTheDataDetailBooksWithoutAuthorized(){
        put.validateDataDetailWithoutAuthorized();
    }

    // Scenario 5.3: PUT (Negative)
    @When("I request PUT detail books with invalid input ISBN")
    public void requestGETDetailBooksWithInvalidInputISBN() {
        put.requestPUTDetailBooksWithInvalidInputISBN();
    }

    @And("validate the data detail books with invalid input ISBN")
    public void validateTheDataDetailBooksWithInvalidInputISBN(){
        put.validateDataDetailWithInvalidInputISBN();
    }

    // Scenario 5.4: PUT (Negative)
    @When("I request PUT detail books with invalid replaced new ISBN")
    public void requestGETDetailBooksWithInvalidReplacedNewISBN() {
        put.requestPUTDetailBooksWithInvalidReplacedNewISBN();
    }

    @And("validate the data detail books with invalid replaced new ISBN")
    public void validateTheDataDetailBooksWithInvalidReplacedNewISBN(){
        put.validateDataDetailWithInvalidReplacedNewISBN();
    }

    // Scenario 5.5: PUT (Negative)
    @When("I request PUT detail books with invalid input userId")
    public void requestGETDetailBooksWithInvalidInputUserId() {
        put.requestPUTDetailBooksWithInvalidInputUserId();
    }

    @And("validate the data detail books with invalid input userId")
    public void validateTheDataDetailBooksWithInvalidInputUserId(){
        put.validateDataDetailWithInvalidInputUserId();
    }
}
