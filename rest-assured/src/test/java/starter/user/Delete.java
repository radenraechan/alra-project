package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.equalTo;

public class Delete {

    private static String base_url = "https://reqres.in/api/";

    @Step("I set an endpoint for DELETE user")
    public String setAnEndpointForDelete(){
        return base_url + "users/2";
    }

    @Step("I request DELETE user")
    public void requestDeleteUser(){
        SerenityRest.given()
                .when()
                .get(setAnEndpointForDelete());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after delete user")
    public void validateDataDetailAfterDeleteUser() {
        SerenityRest.then().body("data.id", equalTo(2));
        SerenityRest.then().body("data.email", equalTo("janet.weaver@reqres.in"));
    }
}
