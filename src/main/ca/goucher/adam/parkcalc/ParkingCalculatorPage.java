package ca.goucher.adam.parkcalc;

import nz.co.bnz.webdriver.WebDriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ParkingCalculatorPage {

    private WebDriver driver;

    public void open() {
        driver = new FirefoxDriver(WebDriverUtils.getDesiredCapabilities());
        driver.get("http://adam.goucher.ca/parkcalc/");
    }

    public void close() {
        driver.quit();
    }

    public void selectLot(String lot) {
        Select lotDropDown = new Select(WebDriverUtils.waitForElementToAppear(driver, By.name("Lot")));
        lotDropDown.selectByVisibleText(lot);
    }

    public void addEntryTime(String time, String ampm) {
        WebElement entryTime = WebDriverUtils.waitForElementToAppear(driver, By.name("EntryTime"));
        entryTime.clear();
        entryTime.sendKeys(time);

        checkAMPM("EntryTime", ampm);
    }

    public void calculate() {
        WebElement calculateButton = WebDriverUtils.waitForElementToAppear(driver, By.name("Submit"));
        calculateButton.click();
    }

    public boolean isCost(String cost) {
        String costCssSelector = "span.SubHead > font:nth-child(1) > b:nth-child(1)";
        return WebDriverUtils.waitForElementToHaveText(driver, By.cssSelector(costCssSelector), cost);
    }

    private void checkAMPM(String time, String ampm) {

        if (ampm.equalsIgnoreCase("AM")) {
            WebElement amCheckbox = WebDriverUtils.waitForElementToAppear(driver,
                By.cssSelector("[name=" + time + "AMPM][value=AM]"));

            if (!amCheckbox.isSelected()) {
                amCheckbox.click();
            }
        }
        else {
            WebElement pmCheckbox = WebDriverUtils.waitForElementToAppear(driver,
                By.cssSelector("[name=" + time + "AMPM][value=PM]"));

            if (!pmCheckbox.isSelected()) {
                pmCheckbox.click();
            }
        }
    }

}
