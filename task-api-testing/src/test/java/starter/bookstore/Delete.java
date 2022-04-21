package starter.bookstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class Delete {

    private static String base_url = "https://demoqa.com/BookStore/v1/";

    // Scenario 4.1: Positive
    @Step("I set an endpoint for DELETE book")
    public String setAnEndpointForDelete(){
        return base_url + "Book";
    }

    @Step("I request DELETE book")
    public void requestDeleteBook(){
        JSONObject requestData = new JSONObject();
        requestData.put("isbn", "9781593275846");
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setAnEndpointForDelete());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after delete book")
    public void validateDataDetailAfterDeleteBook() {
        SerenityRest.then().body("isbn", equalTo("9781593275846"));
    }

    // Scenario 4.2: Negative
    @Step("I request DELETE book without authorized")
    public void requestDeleteBookWithoutAuthorized(){
        JSONObject requestData = new JSONObject();
        requestData.put("isbn", "9781593275846");
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setAnEndpointForDelete());
    }

    @Step("validate the data detail after failed delete book without authorized")
    public void validateDataDetailAfterFailedDeleteBookWithoutAuthorized() {
        SerenityRest.then().body("code", equalTo("1200"));
    }

    // Scenario 4.3: Negative
    @Step("I request DELETE book with invalid userId")
    public void requestDeleteBookWithInvalidUserId(){
        JSONObject requestData = new JSONObject();
        requestData.put("isbn", "9781593275846");
        requestData.put("userId", "string");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setAnEndpointForDelete());
    }

    @Step("validate the data detail after failed delete book with invalid userId")
    public void validateDataDetailAfterFailedDeleteBookWithInvalidUserId() {
        SerenityRest.then().body("code", equalTo("1200"));
    }

    // Scenario 4.4: Negative
    @Step("I request DELETE book with invalid ISBN")
    public void requestDeleteBookWithInvalidISBN(){
        JSONObject requestData = new JSONObject();
        requestData.put("isbn", "9781593275846a");
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setAnEndpointForDelete());
    }

    @Step("validate the data detail after failed delete book with invalid ISBN")
    public void validateDataDetailAfterFailedDeleteBookWithInvalidISBN() {
        SerenityRest.then().body("code", equalTo("1200"));
    }
}
