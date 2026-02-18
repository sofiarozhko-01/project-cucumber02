package utils;

import org.openqa.selenium.WebElement;
import pageInitializer.PageInitializer;

public class CommonMethods extends PageInitializer {

    public void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

}
