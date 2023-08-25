/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcaculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GetInput getInput = new GetInput(); 
        Display display = new Display();
        int[][] matrix1, matrix2, matrixresult;
        //Step 1: Display menu 
        display.DisplayMenu();
        //Loop until the user choose exit program
        while (true) {
            //Step 2: user select an option
            int choice = getInput.getInputOption("Your choice: ", 1, 4);
            switch (choice) {
                //Addition Matrix
                case 1:
                    System.out.println("-------- Addition --------");
                    matrix1 = getInput.getInputFirstMatrix();
                    matrix2 = getInput.getInputSecondMatrix(matrix1, choice);
                    matrixresult = Caculator.additionTwoMatrix(matrix1, matrix2);
                    display.DisplayResult(matrix1, matrix2, matrixresult, choice);
                    break;
                //Subtraction Matrix 
                case 2:
                    System.out.println("----- Subtraction ------"); 
                    matrix1 = getInput.getInputFirstMatrix();
                    matrix2 = getInput.getInputSecondMatrix(matrix1, choice);
                    matrixresult = Caculator.subtractionTwoMatrix(matrix1, matrix2);
                    display.DisplayResult(matrix1, matrix2, matrixresult, choice);
                    break;
                //Multiplication Matrix 
                case 3:
                    System.out.println("-------- Multiplecation --------");
                    matrix1 = getInput.getInputFirstMatrix();
                    matrix2 = getInput.getInputSecondMatrix(matrix1, choice);
                    matrixresult = Caculator.multipleTwoMatrix(matrix1, matrix2);
                    display.DisplayResult(matrix1, matrix2, matrixresult, choice);
                    break;
                //Exit
                case 4:
                    System.exit(0);
            }

        }
    }
}
