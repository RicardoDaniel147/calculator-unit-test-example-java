import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDynamicTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsForSum() {
        int[][] data = new int[][] {
                { 1, 2, 3 },
                { 2, 3, 5 },
                { 3, 4, 7 }
        };

        // parametro -> cuerpo
        /*
         * BinaryOperator<Integer> suma = (a, b) -> {
         * return a + b;
         * };
         */

        // Arreglo -> Stream<int[][]> -> Stream<DynamicTest>
        return Arrays.stream(data).map((item) -> {
            int a = item[0];
            int b = item[1];
            int expected = item[2];

            return dynamicTest("Sumando: " + a + " + " + b + " = " + expected, () -> {
                assertEquals(expected, calculator.sum(a, b));
            });
        });
    }
}
