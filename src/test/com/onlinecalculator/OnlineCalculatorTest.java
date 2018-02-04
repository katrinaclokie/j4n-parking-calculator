package com.onlinecalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnlineCalculatorTest {

    private OnlineCalculatorPage onlineCalculator = new OnlineCalculatorPage();

    @Before
    public void open() {
        onlineCalculator.open();
    }

    @After
    public void close() {
        onlineCalculator.close();
    }

    @Test
    public void checkAddition() {
        onlineCalculator.clickNumber("four");
        onlineCalculator.clickOperator("add");
        onlineCalculator.clickNumber("five");
        onlineCalculator.clickCalculate();

        assertTrue("Sum should be 9", onlineCalculator.isResult("9"));
    }

}
