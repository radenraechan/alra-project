package starter.bookstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class
DeleteWithUserId {

    private static String base_url = "https://demoqa.com/BookStore/v1/";

    // Scenario 2.1: Positive
    @Step("I set an endpoint for DELETE books")
    public String setAnEndpointForDelete(){
        return base_url + "Books?UserId=" + "a7eec432-a3c3-44e6-b931-5be4dee7ff4a";
    }

    @Step("I request DELETE books")
    public void requestDeleteBooks(){
        JSONObject requestData = new JSONObject();
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

    @Step("validate the data detail after delete books")
    public void validateDataDetailAfterDeleteBooks() {
        SerenityRest.then().body("isbn", equalTo("9781593275846"));
    }

    // Scenario 2.2: Negative
    @Step("I request DELETE books without authorized")
    public void requestDeleteBooksWithoutAuthorized(){
        JSONObject requestData = new JSONObject();
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setAnEndpointForDelete());
    }

    @Step("validate the data detail after failed delete books without authorized")
    public void validateDataDetailAfterFailedDeleteBooksWithoutAuthorized() {
        SerenityRest.then().body("code", equalTo("1200"));
    }

    // Scenario 2.3: Negative
    @Step("I request DELETE books with invalid userId")
    public void requestDeleteBooksWithInvalidUserId(){
        JSONObject requestData = new JSONObject();
        requestData.put("userId", "string");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setAnEndpointForDelete());
    }

    @Step("validate the data detail after failed delete books with invalid userId")
    public void validateDataDetailAfterFailedDeleteBooksWithInvalidUserId() {
        SerenityRest.then().body("code", equalTo("1200"));
    }
}
