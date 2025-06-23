package test.java;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.Calculator;

public class CalculatorTest {

    @Test
    public void testCalculate() {
        String input = "2+3";
        String expected = "5.0";
        String actual = Calculator.Run(input);
        assertEquals(expected, actual);
    }
}
