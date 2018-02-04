package nz.co.bnz.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    public static WebElement waitForElementToAppear(WebDriver driver, By by) {
        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean waitForElementToHaveText(WebDriver driver, By by, String text) {
        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.textToBe(by, text));
    }

    public static boolean waitForElementToHaveValue(WebDriver driver, By by, String value) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.attributeContains(by, "value", value));
    }
}
