package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProfilePage extends PageObject {

    private By profileHeader() {
        return By.xpath("//*[@id=\"app\"]/div/div/div[1]/div");
    }

    @Step
    public boolean headerAppears() {
        return $(profileHeader()).isDisplayed();
    }

    @Step
    public boolean headerTextEqual() {
        return $(profileHeader()).getText().equals("Profile");
    }
}
