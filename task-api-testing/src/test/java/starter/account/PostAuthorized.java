package starter.account;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class PostAuthorized {

    private static String base_url = "https://demoqa.com/Account/v1/";

    // Scenario 3.1: Positive
    @Step("I set an endpoint for POST authorize user")
    public String setPostEndpointAuthorizeUser(){
        return base_url + "Authorized";
    }

    @Step("I request POST authorize user")
    public void requestPostAuthorizeUser(){
        JSONObject requestData = new JSONObject();
        requestData.put("userName", "string17");
        requestData.put("password", "String123*");

        SerenityRest.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpointAuthorizeUser());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after authorize user")
    public void validateDataDetailAfterAuthorizeUser(){
        SerenityRest.then().body(equalTo("true"));
    }

    // Scenario 3.2: Negative
    @Step("I request POST authorize user with invalid input password")
    public void requestPostAuthorizeUserWithInvalidInputPassword(){
        JSONObject requestData2 = new JSONObject();
        requestData2.put("userName", "string");
        requestData2.put("password", "string");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData2.toJSONString())
                .when().post(setPostEndpointAuthorizeUser());
    }

    @Step("validate the data detail after failed authorize user with invalid input password")
    public void validateDataDetailAfterFailedAuthorizeUserWithInvalidInputPassword(){
        SerenityRest.then().body("code",equalTo("1207"));
    }

    // Scenario 3.3: Negative
    @Step("I request POST authorize user with null input password")
    public void requestPostAuthorizeUserWithNullInputPassword(){
        JSONObject requestData3 = new JSONObject();
        requestData3.put("userName", "string");
        requestData3.put("password", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData3.toJSONString())
                .when().post(setPostEndpointAuthorizeUser());
    }

    @Step("validate the data detail after failed authorize user with null input password")
    public void validateDataDetailAfterFailedAuthorizeUserWithNullPassword(){
        SerenityRest.then().body("code",equalTo("1200"));
    }
}