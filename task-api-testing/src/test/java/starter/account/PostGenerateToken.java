package starter.account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class PostGenerateToken {

    private static String base_url = "https://demoqa.com/Account/v1/";

    // Scenario 2.1: Positive
    @Step("I set an endpoint for POST new generate token user")
    public String setPostEndpointGenerateTokenUser(){
        return base_url + "GenerateToken";
    }

    @Step("I request POST generate token user")
    public void requestPostGenerateTokenUser(){
        JSONObject requestData = new JSONObject();
        requestData.put("userName", "string");
        requestData.put("password", "String1*");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().post(setPostEndpointGenerateTokenUser());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after generate token user")
    public void validateDataDetailAfterGenerateTokenUser(){
        SerenityRest.then()
                .body("result", equalTo("User authorized successfully."));
    }

    @Step("get token for other request")
    public String getToken() {
        Response response = SerenityRest.lastResponse();
        String token = response.body().path("token");
        System.out.println("Token: " + token);
        return token;
    }

    // Scenario 2.2: Negative
    @Step("I request POST generate token user with invalid input password")
    public void requestPostGenerateTokenUserWithInvalidInputPassword(){
        JSONObject requestData2 = new JSONObject();
        requestData2.put("userName", "string");
        requestData2.put("password", "string");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData2.toJSONString())
                .when().post(setPostEndpointGenerateTokenUser());
    }

    @Step("validate the data detail after failed generate token user")
    public void validateDataDetailAfterFailedGenerateTokenUser(){
        SerenityRest.then().body("status", equalTo("Failed"));
    }

    // Scenario 2.3: Negative
    @Step("I request POST generate token user with null input password")
    public void requestPostGenerateTokenUserWithNullInputPassword(){
        JSONObject requestData3 = new JSONObject();
        requestData3.put("userName", "string");
        requestData3.put("password", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData3.toJSONString())
                .when().post(setPostEndpointGenerateTokenUser());
    }

    @Step("validate the data detail after failed generate token user with null input password")
    public void validateDataDetailAfterFailedGenerateTokenUserWithNullInputPassword(){
        SerenityRest.then().body("code", equalTo("1200"));
    }
}
