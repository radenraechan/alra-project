package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.account.PostAuthorized;
import starter.account.PostGenerateToken;
import starter.account.Delete;
import starter.account.Get;
import starter.account.Post;

public class accountStep {
    String userId, token;

    @Steps
    Post post;

    @Steps
    PostGenerateToken postGenerateToken;

    @Steps
    PostAuthorized postAuthorized;

    @Steps
    Get get;

    @Steps
    Delete delete;

    // Scenario 1.1: POST new user (Positive)
    @Given("I set an endpoint for POST new user")
    public void setAnEndpointForPOSTNewUser() {
        post.setPostEndpoint();
    }

    @When("I request POST detail user")
    public void requestPOSTDetailUser() {
        post.requestPostDetailUser();
    }

    @Then("I validate the status code for account is 201")
    public void validateTheStatusCodeForAccountIs201() {
        post.validateStatusCode(201);
    }

    @Then("validate the data detail after create user")
    public void validateTheDataDetailAfterCreateUser() {
        post.validateDataDetail();
    }

    @And("get userId for other request")
    public void getUserIdForOtherRequest() {
        this.userId = post.getUserId();
        System.out.println("User ID di Step: " + userId);
    }

    // Scenario 1.2: POST new user (Negative)
    @When("I request POST detail user that have same userName and same password")
    public void requestPOSTDetailUserThatHaveSameUsernameAndPassword() {
        post.requestPOSTDetailUserThatHaveSameUsernameAndPassword();
    }

    @Then("I validate the status code for account is 406")
    public void validateTheStatusCodeForAccountIs406() {
        post.validateStatusCode(406);
    }

    @Then("validate the data detail after failed create user")
    public void validateTheDataDetailAfterFailedCreateUser() {
        post.validateDataDetailAfterFailedCreateUser(post.getCode());
    }

    @And("get code for validate")
    public void getCode() {
        post.getCode();
    }

    // Scenario 1.3: POST new user (Negative)
    @When("I request POST detail user with invalid input password")
    public void requestPOSTDetailUserWithInvalidInputPassword() {
        post.requestPOSTDetailUserWithInvalidInputPassword();
    }

    @Then("I validate the status code for account is 400")
    public void validateTheStatusCodeForAccountIs400() {
        post.validateStatusCode(400);
        postGenerateToken.validateStatusCode(400);
        postAuthorized.validateStatusCode(400);
    }

    // Scenario 1.4: POST new user (Negative)
    @When("I request POST detail user with null input password")
    public void requestPOSTDetailUserWithNullInputPassword() {
        post.requestPOSTDetailUserWithNullInputPassword();
    }

    // Scenario 2.1: POST generate token user (Positive)
    @Given("I set an endpoint for POST new generate token user")
    public void setAnEndpointForPOSTNewGenerateTokenUser() {
        postGenerateToken.setPostEndpointGenerateTokenUser();
    }

    @When("I request POST generate token user")
    public void requestPOSTGenerateTokenUser() {
        postGenerateToken.requestPostGenerateTokenUser();
    }

    @Then("I validate the status code for account is 200")
    public void validateTheStatusCodeForAccountIs200() {
        postGenerateToken.validateStatusCode(200);
        postAuthorized.validateStatusCode(200);
        get.validateStatusCode(200);
        delete.validateStatusCode(200);
    }

    @And("validate the data detail after generate token user")
    public void validateTheDataDetailAfterGenerateTokenUser() {
        postGenerateToken.validateDataDetailAfterGenerateTokenUser();
    }

    @And("get token for other request")
    public void getTokenForOtherRequest() {
        this.token = postGenerateToken.getToken();
        System.out.println("Token di Step: " + token);
    }

    // Scenario 2.2: POST generate token user (Negative)
    @When("I request POST generate token user with invalid input password")
    public void requestPOSTGenerateTokenUserWithInvalidInputPassword() {
        postGenerateToken.requestPostGenerateTokenUserWithInvalidInputPassword();
    }

    @And("validate the data detail after failed generate token user")
    public void validateTheDataDetailAfterFailedGenerateTokenUser() {
        postGenerateToken.validateDataDetailAfterFailedGenerateTokenUser();
    }

    // Scenario 2.3: POST generate token user (Negative)
    @When("I request POST generate token user with null input password")
    public void requestPOSTGenerateTokenUserWithNullInputPassword() {
        postGenerateToken.requestPostGenerateTokenUserWithNullInputPassword();
    }

    @And("validate the data detail after failed generate token user with null input password")
    public void validateTheDataDetailAfterFailedGenerateTokenUserWithNullInputPassword() {
        postGenerateToken.validateDataDetailAfterFailedGenerateTokenUserWithNullInputPassword();
    }

    // Scenario 3.1: POST authorize user (Positive)
    @Given("I set an endpoint for POST authorize user")
    public void setAnEndpointForPOSTAuthorizeUser() {
        postAuthorized.setPostEndpointAuthorizeUser();
    }

    @When("I request POST authorize user")
    public void requestPOSTAuthorizeUser() {
        postAuthorized.requestPostAuthorizeUser();
    }

    @And("validate the data detail after authorize user")
    public void validateTheDataDetailAfterAuthorizeUser() {
        postAuthorized.validateDataDetailAfterAuthorizeUser();
    }

    // Scenario 3.2: POST authorize user (Negative)
    @When("I request POST authorize user with invalid input password")
    public void requestPOSTAuthorizeUserWithInvalidInputPassword() {
        postAuthorized.requestPostAuthorizeUserWithInvalidInputPassword();
    }

    @Then("I validate the status code for account is 404")
    public void validateTheStatusCodeForAccountIs404() {
        postAuthorized.validateStatusCode(404);
    }

    @And("validate the data detail after failed authorize user with invalid input password")
    public void validateTheDataDetailAfterFailedAuthorizeUserWithInvalidInputPassword() {
        postAuthorized.validateDataDetailAfterFailedAuthorizeUserWithInvalidInputPassword();
    }

    // Scenario 3.3: POST authorize user (Negative)
    @When("I request POST authorize user with null input password")
    public void requestPOSTAuthorizeUserWithNullInputPassword() {
        postAuthorized.requestPostAuthorizeUserWithNullInputPassword();
    }

    @And("validate the data detail after failed authorize user with null input password")
    public void validateTheDataDetailAfterFailedAuthorizeUserWithNullInputPassword() {
        postAuthorized.validateDataDetailAfterFailedAuthorizeUserWithNullPassword();
    }

    // Scenario 4.1: GET (Positive)
    @Given("I set an endpoint for GET detail user")
    public void setAnEndpointForGETDetailUser() {
        System.out.println("User Id: " + post.getUserId());
        System.out.println("User Id di GET: " + userId);
        get.setAnEndpointForGet(userId);
    }

    @When("I request GET detail user")
    public void requestGETDetailUser() {
        System.out.println("User Id: " + post.getUserId());
        System.out.println("User Id di GET: " + userId);
        System.out.println("Token: " + postGenerateToken.getToken());
        System.out.println("Token di GET: " + token);
        get.requestGetDetailUser(userId, token);
    }

    @And("validate the data detail")
    public void validateTheDataDetail() {
        System.out.println("User Id: " + post.getUserId());
        System.out.println("User Id di GET: " + userId);
        get.validateDataDetail(userId);
    }

    // Scenario 5.1: DELETE (Positive)
    @Given("I set an endpoint for DELETE user")
    public void setAnEndpointForDELETEUser() {
        System.out.println("User Id: " + post.getUserId());
        System.out.println("User Id di GET: " + userId);
        delete.setAnEndpointForDelete(userId);
    }

    @When("I request DELETE user")
    public void requestDELETEUser() {
        System.out.println("User Id: " + post.getUserId());
        System.out.println("User Id di GET: " + userId);
        System.out.println("Token: " + postGenerateToken.getToken());
        System.out.println("Token di GET: " + token);
        delete.requestDeleteUser(userId, token);
    }

    @And("validate the data detail after delete user")
    public void validateTheDataDetailAfterDeleteUser() {
        delete.validateDataDetailAfterDeleteUser();
    }
}
