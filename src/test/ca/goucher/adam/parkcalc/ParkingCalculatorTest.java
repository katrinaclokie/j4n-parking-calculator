package ca.goucher.adam.parkcalc;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingCalculatorTest {

    private ParkingCalculatorPage parkingCalculator = new ParkingCalculatorPage();

    @Before
    public void openBrowser() {
        parkingCalculator.open();
    }

    @After
    public void closeBrowser() {
        parkingCalculator.close();
    }

    @Test
    public void noEntryDate() {
        parkingCalculator.selectLot("Short-Term Parking");
        parkingCalculator.addEntryTime("10:30", "PM");
        parkingCalculator.calculate();

        assertTrue("No entry date should give an error", parkingCalculator.isCost("ERROR! ENTER A CORRECTLY FORMATTED DATE"));
    }

}
