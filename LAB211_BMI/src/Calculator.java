/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kieup
 */
public class Calculator {

    GetInput input = new GetInput();

    public static void NormalCaculator() {
        double memory = GetInput.getInput("Enter number: ");
        while (true) {
            String operator = GetInput.getOperator("Enter operator: ");
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                break;
            }
            double number = GetInput.getInput("Enter number: ");
            switch (operator) {
                case "+":
                    memory += number;
                    System.out.println("Memory: " + memory);
                    break;
                case "-":
                    memory -= number;
                    System.out.println("Memory: " + memory);
                    break;
                case "*":
                    memory *= number;
                    System.out.println("Memory: " + memory);
                    break;
                case "/":
                    if (memory == 0) {
                        if (number == 0) {
                            System.out.println("Don't caculate equation!");
                            number = GetInput.getInput("Enter number: ");
                            memory /= number;
                            System.out.println("Memory: " + memory);
                        }
                    } else if (memory != 0) {
                        if (number == 0) {
                            System.out.println("Don't caculate equation!");
                            number = GetInput.getInput("Enter number: ");
                            memory /= number;
                            System.out.println("Memory: " + memory);
                        }
                    } else {
                        memory /= number;
                        System.out.println("Memory: " + memory);
                    }
                    break;
                case "^":
                    if (memory == 0 && number == 0 ) {
                            System.out.println("Don't caculate equation!");
                            System.out.println(memory + "^" + number);
                            number = GetInput.getInput("Enter number: ");
                            System.out.println(memory + "^" + number);
                            memory = Math.pow(memory, number);
                            System.out.println("Memory: " + memory);
                        }
                    else if (memory == 0 && number < 0) {
                            System.out.println("Don't caculate equation!");
                            System.out.println(memory + "^" + number);
                            number = GetInput.getInput("Enter number: ");
                            System.out.println(memory + "^" + number);
                            memory = Math.pow(memory, number);
                            System.out.println("Memory: " + memory);
                    } 
                    else {
                        memory = Math.pow(memory, number);
                        System.out.println("Memory: " + memory);
                    }
                    break;
            }
        }
    }

    public static void BMI() {
        double weight = GetInput.getInputBMI("Enter Weight(kg): ");
        double height = GetInput.getInputBMI("Enter Height(cm): ");
        double bmi = (weight * 10000) / (height * height);
        System.out.printf("BMI number: %2f\n", bmi);
        if (bmi < 19) {
            System.out.println("Under-standard.");
        } else if (bmi >= 19 && bmi < 25) {
            System.out.println("Standard.");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Overweight.");
        } else if (bmi >= 30 && bmi < 40) {
            System.out.println("Fat-should lose weight");
        } else {
            System.out.println("Very fat - should lose weight immediately");
        }
    }
}
