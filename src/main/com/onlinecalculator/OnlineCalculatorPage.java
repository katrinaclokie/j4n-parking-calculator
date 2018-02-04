package com.onlinecalculator;

import nz.co.bnz.webdriver.WebDriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineCalculatorPage {

    private WebDriver driver;

    public void open() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", "C:/dev/bin/chromedriver_win32/chromedriver.exe");
        }

        driver = new ChromeDriver();
        driver.get("http://www.theonlinecalculator.com/");
    }

    public void close() {
        driver.quit();
    }

    public void clickNumber(String num) {
        WebElement number = WebDriverUtils.waitForElementToAppear(driver, By.name(num));
        number.click();
    }

    public void clickOperator(String op) {
        WebElement operator = WebDriverUtils.waitForElementToAppear(driver, By.name(op));
        operator.click();
    }

    public void clickCalculate() {
        WebElement calculate = WebDriverUtils.waitForElementToAppear(driver, By.name("calculate"));
        calculate.click();
    }

    public boolean isResult(String result) {
        return WebDriverUtils.waitForElementToHaveValue(driver, By.id("display"), result);
    }

}
