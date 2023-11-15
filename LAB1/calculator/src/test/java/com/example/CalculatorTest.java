package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    void addIntegers() {
        assertEquals(8.0, calculator.add(5.0, 3.0));
    }
    @Test
    void testSubtraction() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0));
    }

    @Test
    void testMultiplication() {
        assertEquals(15.0, calculator.multiply(3.0, 5.0));
    }

    @Test
    void testDivision() {
        assertEquals(4.0, calculator.divide(8.0, 2.0));
    }
    @Test
    void testAdditionWithNegativeNumbers() {
        assertEquals(-1.0, calculator.add(-2.0, 1.0));
    }

    @Test
    void testSubtractionWithNegativeResult() {
        assertEquals(-3.0, calculator.subtract(2.0, 5.0));
    }

    @Test
    void testMultiplicationWithZero() {
        assertEquals(0.0, calculator.multiply(3.0, 0.0));
    }

    @Test
    void testDivisionWithNegativeResult() {
        assertEquals(-2.0, calculator.divide(8.0, -4.0));
    }

    @Test
    void testNotNullCalculator() {
        assertNotNull(calculator);
    }

    @Test
    void testIsPositive() {
        assertTrue(calculator.add(2.0, 3.0) > 0);
    }
  
    @Test
    void testIsNotNegative() {
        assertFalse(calculator.subtract(5.0, 3.0) < 0);
    }
  
    @Test
    void testMultiplicationNotEquals() {
        double result = calculator.multiply(2.0, 5.0);
        assertNotEquals(result!=10, result);
    }
}