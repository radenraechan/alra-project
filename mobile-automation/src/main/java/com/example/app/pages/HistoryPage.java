package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HistoryPage extends BasePageObject {

    By historyTitle() {
        return By.xpath("//android.view.View[@content-desc=\"History\"]");
    }

    By deleteButton() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
    }

    public void validateOnHistoryPage() {
        Assertions.assertTrue(isDisplayed(historyTitle()));
//        Assertions.assertEquals("History", getText(historyTitle()));
    }

    public void clickDeleteButton() {
        click(deleteButton());
    }

}
