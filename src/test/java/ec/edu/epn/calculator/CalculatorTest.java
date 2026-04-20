package ec.edu.epn.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(4, calculator.sum(2, 2));
    }

    @Test
    public void testMinus() {
        assertEquals(1, calculator.minus(2, 1));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivideSuccesfull() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
    }
}
