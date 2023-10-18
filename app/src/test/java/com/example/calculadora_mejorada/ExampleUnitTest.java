package com.example.calculadora_mejorada;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    public class CalculatorTest {

        @Test
        public void testAdd2Operands() {
            Calculator calc = new Calculator();
            calc.appendNumber(5);
            calc.setOperator("+");
            calc.appendNumber(3);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("X + Y operations not working correctly", 8, total);
        }

        @Test
        public void testAdd1Operand() {
            Calculator calc = new Calculator();
            calc.appendNumber(4);
            calc.setOperator("+");
            calc.appendNumber(3);
            calc.setOperator("+");
            calc.appendNumber(1);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("+X operations not working correctly", 8, total);
        }

        @Test
        public void testMult2Operands() {
            Calculator calc = new Calculator();
            calc.appendNumber(4);
            calc.setOperator("*");
            calc.appendNumber(2);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("4*X operations not working correctly", 8, total);
        }

        @Test
        public void testMultNumbers() {
            Calculator calc = new Calculator();
            calc.appendNumber(2);
            calc.setOperator("*");
            calc.appendNumber(3);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("Multiplication of two numbers failed", 6, total);
        }

        @Test
        public void testMultMultipleNumbers() {
            Calculator calc = new Calculator();
            calc.appendNumber(1);
            calc.setOperator("*");
            calc.appendNumber(2);
            calc.setOperator("*");
            calc.appendNumber(8);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("Multiplication of multiple numbers failed", 16, total);
        }

        @Test
        public void testComplexExpression1() {
            Calculator calc = new Calculator();
            calc.appendNumber(2);
            calc.setOperator("*");
            calc.appendNumber(2);
            calc.setOperator("+");
            calc.appendNumber(3);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("Complex expression failed", 7, total);
        }

        @Test
        public void testComplexExpression2() {
            Calculator calc = new Calculator();
            calc.appendNumber(3);
            calc.setOperator("+");
            calc.appendNumber(2);
            calc.setOperator("*");
            calc.appendNumber(2);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("Complex expression failed", 7, total);
        }

        @Test
        public void testComplexExpression3() {
            Calculator calc = new Calculator();
            calc.appendNumber(3);
            calc.setOperator("+");
            calc.appendNumber(2);
            calc.setOperator("*");
            calc.appendNumber(2);
            calc.setOperator("+");
            calc.appendNumber(4);
            calc.calculate();
            int total = Integer.parseInt(calc.getCurrentInput());
            assertEquals("Complex expression failed", 11, total);
        }
    }
}
