package com.example;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select operation: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        System.out.print("Enter choice (1-4): ");
        int choice = scanner.nextInt();

        double result = calculate(num1, num2, choice);

        System.out.println("Result: " + result);
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Error! Division by zero is not allowed.");
        }
    }

    public static double calculate(double num1, double num2, int operation) {
        switch (operation) {
            case 1:
                return add(num1, num2);
            case 2:
                return subtract(num1, num2);
            case 3:
                return multiply(num1, num2);
            case 4:
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation. Please choose a number between 1 and 4.");
        }
    }
}