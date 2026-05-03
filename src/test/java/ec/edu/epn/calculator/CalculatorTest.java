package ec.edu.epn.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    /*
     * Fases de una prueba unitaria:
     * 1. Arrange
     * 2. Act
     * 3. Assert
     */

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Arrange
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test para la suma de dos números")
    public void testSum() {
        // Act + Assert
        // assertEquals(4, calculator.sum(2, 2));
        assertAll("Suma valores en varios casos",
                () -> assertEquals(4, calculator.sum(2, 2)),
                () -> assertEquals(5, calculator.sum(2, 3)),
                () -> assertEquals(6, calculator.sum(3, 3)));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "3, 4, 7"
    })
    public void testMultipleData(int a, int b, int expected) {
        // arrange
        calculator = new Calculator();
        int result = calculator.sum(a, b);
        // Assert
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    public void testSumWithFixedValues(int value) {
        // Arrange + Act
        int result = calculator.sum(value, 0);
        // Assert
        assertTrue(value == result);
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
