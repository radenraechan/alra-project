package starter.account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class Post {

    private static String base_url = "https://demoqa.com/Account/v1/";

    // Scenario 1.1: Positive
    @Step("I set an endpoint for POST new user")
    public String setPostEndpoint(){
        return base_url + "User";
    }

    @Step("I request POST detail user")
    public void requestPostDetailUser(){
        JSONObject requestData = new JSONObject();
        requestData.put("userName", "string17");
        requestData.put("password", "String123*");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpoint());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after create user")
    public void validateDataDetail(){
        SerenityRest.then()
                .body("userName", equalTo("string17"));
    }

    @Step("get userId for other request")
    public String getUserId() {
        Response response = SerenityRest.lastResponse();
        String userId = response.body().path("userID");
        System.out.println("User ID: " + userId);
        return userId;
    }

    // Scenario 1.2: Negative
    @Step("I request POST detail user that have same userName and same password")
    public void requestPOSTDetailUserThatHaveSameUsernameAndPassword() {
        JSONObject requestData2 = new JSONObject();
        requestData2.put("userName", "string");
        requestData2.put("password", "String123*");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData2.toJSONString())
                .when().post(setPostEndpoint());
    }

    @Step("validate the data detail after failed create user")
    public void validateDataDetailAfterFailedCreateUser(String code){
        SerenityRest.then().body("code", equalTo(code));
    }

    @Step("get code for validate")
    public String getCode() {
        Response response = SerenityRest.lastResponse();
        String code = response.body().path("code");
        System.out.println("Code: " + code);
        return code;
    }

    // Scenario 1.3: Negative
    @Step("I request POST detail user with invalid input password")
    public void requestPOSTDetailUserWithInvalidInputPassword() {
        JSONObject requestData3 = new JSONObject();
        requestData3.put("userName", "string");
        requestData3.put("password", "string");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData3.toJSONString())
                .when().post(setPostEndpoint());
    }

    // Scenario 1.4: Negative
    @Step("I request POST detail user with null input password")
    public void requestPOSTDetailUserWithNullInputPassword() {
        JSONObject requestData4 = new JSONObject();
        requestData4.put("userName", "string");
        requestData4.put("password", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData4.toJSONString())
                .when().post(setPostEndpoint());
    }
}
