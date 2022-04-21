package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CalculatorPage extends BasePageObject {

    By historyButton() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }

    By inputByClick(String input) {
        return By.xpath("//android.view.View[@content-desc=\"" + input + "\"]");
    }

    public void validateOnCalculatorPage() {
        Assertions.assertTrue(isDisplayed(inputByClick("Calculator")));
//        Assertions.assertEquals("Calculator", getText(inputByClick("Calculator")));
    }

    public void clickNumber(String number) {
        if (number.length() > 1) {
            for (int i = 0; i < number.length(); i++) {
                click(inputByClick(String.valueOf(number.charAt(i))));
            }
        } else {
            click(inputByClick(number));
        }
    }

    public void clickSymbolButton(String symbol) {
        click(inputByClick(symbol));
    }

    public void verifyResultDisplayed(String result){
        Assertions.assertTrue(isDisplayed(inputByClick(result)));
//        Assertions.assertEquals(getText(inputByClick(result)), result);
    }

    public void clickHistoryButton() {
        click(historyButton());
    }
}
