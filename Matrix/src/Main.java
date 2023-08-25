
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kieup
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        GetInput getInput = new GetInput();
        Menu menu = new Menu();
        int[][] matrix1;
        int[][] matrix2;
        int[][] matrixresult;
        //Display menu 
        menu.DisplayMenu();
        //Loop until the user choose exit program
        while (true) {
            int choice = getInput.getInputOption("Your choice: ", 1, 4);
            //Step 2: Execute option base on user's choosen
            switch (choice) {
                //Addition Matrixes
                case 1:
                    System.out.println("-------- Addition --------");
                    //1. Enter input the first matrix 
                    matrix1 = getInput.getInputMatrix1();
                    //2. Enter input the second matrix
                    matrix2 = getInput.getInputMatrix2(matrix1, choice);
                    //3. Add two input matrix
                    matrixresult = Caculator.additionMatrix(matrix1, matrix2);
                    //4.Display result
                    menu.DisplayResult(matrix1, matrix2, matrixresult, choice);
                    break;
                //Subtraction Matrix
                case 2:
                    System.out.println("----- Subtraction ------");
                    //1. Enter input the first matrix 
                    matrix1 = getInput.getInputMatrix1();
                    //2. Enter input the second matrix
                    matrix2 = getInput.getInputMatrix2(matrix1, choice);
                    //3. Add two input matrix
                    matrixresult = Caculator.subtractionMatrix(matrix1, matrix2);
                    //4.Display result
                    menu.DisplayResult(matrix1, matrix2, matrixresult, choice);
                    break;
                //Multiplecation Matrix
                case 3:
                    System.out.println("-------- Multiplecation --------");
                    //1. Enter input the first matrix 
                    matrix1 = getInput.getInputMatrix1();
                    //2. Enter input the second matrix
                    matrix2 = getInput.getInputMatrix2(matrix1, choice);
                    //3. Add two input matrix
                    matrixresult = Caculator.multipleMatrix(matrix1, matrix2);
                    //4.Display result
                    menu.DisplayResult(matrix1, matrix2, matrixresult, choice);
                    break;
                case 4: break;
            }
        }
    }
}
