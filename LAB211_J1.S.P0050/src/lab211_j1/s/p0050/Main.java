/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1.s.p0050;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        //Loop until user chooose exit program
        while (true) {
            //Step 1: Display menu 
            DisplayMenu();
            //Step 2: users to selection an option();
            int choice = GetInput.getChoice("Please choice one option:", 1, 3);
            switch (choice) {
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    float numb1 = GetInput.getInput("Enter A: ");
                    float numb2 = GetInput.getInput("Enter B: ");
                    List<Float> solution = Calculator.Calculate(numb1, numb2);
                    Calculator.DisplayOddNumber((ArrayList<Float>) solution, "Number Odd is:");
                    Calculator.DisplayEvenNumber((ArrayList<Float>) solution, "Number Even is:");
                    Calculator.DisplayPerfectNumber((ArrayList<Float>) solution, "Perfect Square is:");
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    float numb3 = GetInput.getInput("Enter A: ");
                    float numb4 = GetInput.getInput("Enter B: ");
                    float numb5 = GetInput.getInput("Enter C: ");
                    List<Float> result = Calculator.CalculateQuadraticEquation(numb3, numb4, numb5);
                    Calculator.DisplayOddNumber((ArrayList<Float>) result, "Number Odd(s):");
                     Calculator.DisplayEvenNumber((ArrayList<Float>) result, "Number Even is:");
                    Calculator.DisplayPerfectNumber((ArrayList<Float>) result, "Perfect Square is:");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    public static void DisplayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }
}
