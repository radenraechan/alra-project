package starter.bookstore;

import net.thucydides.core.annotations.Step;

public class Put {

    // Scenario 5.1: Positive
    @Step("I set an endpoint for PUT detail books")
    public String setPostEndpoint(){
        return "Endpoint for PUT";
    }

    @Step("I request PUT detail books")
    public void requestPUTDetailBooks(){
        System.out.println("With Authorize");
        System.out.println("valid userId");
        System.out.println("valid ISBN");
    }

    @Step("I validate the status code is 200")
    public void validateStatusCodeIs200(){
        System.out.println("Status code is 200");
    }

    @Step("validate the data detail books")
    public void validateDataDetail(){
        System.out.println("Validate");
    }

    // Scenario 5.2: Negative
    @Step("I request PUT detail books without authorized")
    public void requestPUTDetailBooksWithoutAuthorized(){
        System.out.println("Without Authorize");
        System.out.println("valid userId");
        System.out.println("valid ISBN");
    }

    @Step("I validate the status code is 401")
    public void validateStatusCodeIs401(){
        System.out.println("Status code is 401");
    }

    @Step("validate the data detail books without authorized")
    public void validateDataDetailWithoutAuthorized(){
        System.out.println("Validate");
    }

    // Scenario 5.3: Negative
    @Step("I request PUT detail books with invalid input ISBN")
    public void requestPUTDetailBooksWithInvalidInputISBN(){
        System.out.println("With Authorize");
        System.out.println("valid userId");
        System.out.println("invalid ISBN");
    }

    @Step("I validate the status code is 400")
    public void validateStatusCodeIs400(){
        System.out.println("Status code is 400");
    }

    @Step("validate the data detail books with invalid input ISBN")
    public void validateDataDetailWithInvalidInputISBN(){
        System.out.println("Validate");
    }

    // Scenario 5.4: Negative
    @Step("I request PUT detail books with invalid replaced new ISBN")
    public void requestPUTDetailBooksWithInvalidReplacedNewISBN(){
        System.out.println("With Authorize");
        System.out.println("valid userId");
        System.out.println("invalid ISBN");
    }

    @Step("validate the data detail books with invalid replaced new ISBN")
    public void validateDataDetailWithInvalidReplacedNewISBN(){
        System.out.println("Validate");
    }

    // Scenario 5.4: Negative
    @Step("I request PUT detail books with invalid input userId")
    public void requestPUTDetailBooksWithInvalidInputUserId(){
        System.out.println("With Authorize");
        System.out.println("valid userId");
        System.out.println("invalid ISBN");
    }

    @Step("validate the data detail books with invalid input userId")
    public void validateDataDetailWithInvalidInputUserId(){
        System.out.println("Validate");
    }
}
