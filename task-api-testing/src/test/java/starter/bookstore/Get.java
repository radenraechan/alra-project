package starter.bookstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class Get {

    protected static String base_url = "https://demoqa.com/BookStore/v1/";

    // Scenario 3.1: Positive
    @Step("I set an endpoint for GET detail book")
    public String setAnEndpointForGet(String isbn){
        return base_url + "Book?ISBN=" + isbn;
    }

    @Step("I request GET detail book")
    public void requestGetDetailBook(){
        JSONObject requestData = new JSONObject();
        requestData.put("ISBN", "9781449325862");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().get(setAnEndpointForGet("9781449325862"));
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail")
    public void validateDataDetail() {
        SerenityRest.then().body("isbn", equalTo("9781449325862"));
    }

    // Scenario 3.2: Negative
    @Step("I request GET detail book with input invalid ISBN")
    public void requestGetDetailBookWithInputInvalidISBN(){
        JSONObject requestData = new JSONObject();
        requestData.put("ISBN", "9781449325862a");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().get(setAnEndpointForGet("9781449325862a"));
    }

    @Step("validate the data detail with input invalid ISBN")
    public void validateDataDetailWithInputInvalidISBN() {
        SerenityRest.then().body("code", equalTo("1205"));
    }

    // Scenario 3.3: Negative
    @Step("I request GET detail book with input null ISBN")
    public void requestGetDetailBookWithInputNullISBN(){
        JSONObject requestData = new JSONObject();
        requestData.put("ISBN", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when().get(setAnEndpointForGet(""));
    }

    @Step("validate the data detail with input null ISBN")
    public void validateDataDetailWithInputNullISBN() {
        SerenityRest.then().body("code", equalTo("1205"));
    }
}
