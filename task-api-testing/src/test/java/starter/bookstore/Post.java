package starter.bookstore;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Post {

    private static String base_url = "https://demoqa.com/BookStore/v1/";

    // Scenario 1.1: Positive
    @Step("I set an endpoint for POST get book")
    public String setPostEndpoint(){
        return base_url + "Books";
    }

    @Step("I request POST detail book")
    public void requestPostDetailBook(){
        JSONObject requestData = new JSONObject();
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");
        requestData.put("isbn", "9781449325862");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpoint());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after get book")
    public void validateDataDetail(){
        SerenityRest.then().body("isbn", equalTo("9781449325862"));
    }

    // Scenario 1.2: Negative
    @Step("I request POST detail book without authorized")
    public void requestPostDetailBookWithoutAuthorized(){
        JSONObject requestData = new JSONObject();
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");
        requestData.put("isbn", "9781449325862");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpoint());
    }

    @Step("validate the data detail after failed get book without authorized")
    public void validateDataDetailAfterFailedGetBookWithoutAuthorized(){
        SerenityRest.then().body("code", equalTo("1200"));
    }

    // Scenario 1.3: Negative
    @Step("I request POST detail book with invalid input userId")
    public void requestPostDetailBookWithInvalidInputUserId(){
        JSONObject requestData = new JSONObject();
        requestData.put("userId", "string");
        requestData.put("isbn", "9781449325862");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpoint());
    }

    @Step("validate the data detail after failed get book with invalid input userId")
    public void validateDataDetailAfterFailedGetBookWithInvalidInputUserId(){
        SerenityRest.then().body("code", equalTo("1207"));
    }

    // Scenario 1.4: Negative
    @Step("I request POST detail book with invalid input ISBN")
    public void requestPostDetailBookWithInvalidInputISBN(){
        JSONObject requestData = new JSONObject();
        requestData.put("userId", "a7eec432-a3c3-44e6-b931-5be4dee7ff4a");
        requestData.put("isbn", "9781449325862a");

        SerenityRest.given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0cmluZyIsInBhc3N3b3JkIjoiU3RyaW5nMTIqIiwiaWF0IjoxNjQ4MTg5OTcxfQ.sQowi6fy9sUBXsRytqoXUQfQhlbyO48FfCOhKiCzbb0")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpoint());
    }

    @Step("validate the data detail after failed get book with invalid input ISBN")
    public void validateDataDetailAfterFailedGetBookWithInvalidInputISBN(){
        SerenityRest.then().body("code", equalTo("1200"));
    }
}
