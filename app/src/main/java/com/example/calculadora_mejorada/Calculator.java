package com.example.calculadora_mejorada;

public class Calculator {


    private StringBuilder currentInput;
    private String currentOperator;
    private String calculationBuffer;

    public Calculator() {
        currentInput = new StringBuilder();
        currentOperator = null;
        calculationBuffer = "";
    }

    public void appendNumber(int number) {
        if (currentInput.toString().equals("0")) {
            currentInput = new StringBuilder();
        }
        currentInput.append(number);
    }

    public void setOperator(String operator) {
        if (currentOperator != null && !currentInput.toString().isEmpty()) {
            calculate();
        }
        currentOperator = operator;
        calculationBuffer = currentInput.toString();
        currentInput = new StringBuilder();
    }

    public void calculate() {
        if (!calculationBuffer.isEmpty() && !currentInput.toString().isEmpty()) {
            int operand1 = Integer.parseInt(calculationBuffer);
            int operand2 = Integer.parseInt(currentInput.toString());
            int result = 0;

            switch (currentOperator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
            }

            currentInput = new StringBuilder(String.valueOf(result));
            calculationBuffer = currentInput.toString();
            currentOperator = null;
        }
    }

    public void clearCalculator() {
        currentInput = new StringBuilder();
        currentOperator = null;
        calculationBuffer = "";
    }

    public String getCurrentInput() {
        return currentInput.toString();
    }
}
