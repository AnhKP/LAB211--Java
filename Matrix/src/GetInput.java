
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
public class GetInput {

    public static int getInputOption(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int choice = -1;
        //loop until user enter a integer in range from 1 to 4
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            //check input is empty or not 
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                choice = Integer.parseInt(input);
                //check choice is a integer in range min and max or not 
                if (choice < min || choice > max) {
                    System.out.println("Inpur in range" + min + " and " + max);
                    continue;
                }
                return choice;
            } catch (NumberFormatException ex) {
                System.out.println("Input muse be integer!!");
            }
        }
    }

    public static int checkInputMatrix(String str) {
        Scanner sc = new Scanner(System.in);
        //loop until the user's value enter is valid
        while (true) {
            System.out.print(str);
            String input = sc.nextLine();
            //check input is empty or not 
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                int output = Integer.parseInt(input);
                return output;
            } catch (NumberFormatException ex) {
                System.out.println("Value in matrix is digit!!");
            }
        }
    }

   public static int getInput(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        //loop until user enter a integer in range from 1 to 4
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            //check input is empty or not 
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                int output = Integer.parseInt(input);
                //check ouput is a integer in range min to max
                if (output < min || output > max) {
                    System.out.println("Inpur in range" + min + " and " + max);
                    continue;
                }
                return output;
            } catch (NumberFormatException ex) {
                System.out.println("Input muse be integer!!");
            }
        }
    }

   public static int[][] getInputMatrix1() {
        int rows1 = getInput("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        int columns1 = getInput("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[rows1][columns1];
        //loop use to access from first of row to last element of row of matrix
        for (int i = 0; i < rows1; i++) {
            //loop use to access from first of column to last element of column of matrix
            for (int j = 0; j < columns1; j++) {
                matrix1[i][j] = checkInputMatrix("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
        return matrix1;
    }

  public static  int[][] getInputMatrix2(int[][] matrix1, int choice) {
        int[][] matrix2 = null;
        int rows2, columns2;
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        //check if user's choice is 3 or not
        if (choice == 3) {
            //loop until user enter row,column matrix valid with option require
            while (true) {
                rows2 = getInput("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check length of row of matrix2 is equal the length of column of matrix1
                if (rows2 != columns1) {
                    System.out.println("Row of Matrix 2 must be equal column of matrix 1!!");
                    continue;
                }
                columns2 = getInput("Enter Column Matrix 2: ", 1, Integer.MAX_VALUE);
                break;
            }
        } else {
            //loop until user enter row matrix valid with option require
            while (true) {
                rows2 = getInput("Enter Row Matrix2:", 1, Integer.MAX_VALUE);
                //check length of row of matrix2 is equal the length of column of matrix1
                if (rows2 != rows1) {
                    System.out.println("Row of matrix 2 must be equal row of matrix 1!!");
                    continue;
                } else {
                    break;
                }
            }
            //loop until user enter column matrix valid with option require
            while (true) {
                columns2 = getInput("Enter Column Matrix2: ", 1, Integer.MAX_VALUE);
                //Check column of matrix1 is equal column of matrix1 or not
                if (columns2 != columns1) {
                    System.out.println("Column of matrix 2 must be equal column of matrix 1!!");
                    continue;
                } else {
                    break;
                }
            }
        }
        //loop use to access from first of row to last element of row of matrix
        for (int i = 0; i < rows2; i++) {
            //loop use to access from first of column to last element of column of matrix
            for (int j = 0; j < columns2; j++) {
                matrix1[i][j] = checkInputMatrix("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
        return matrix2;
    }
}
//Dieu kien nhan hai ma tran: cot A = hang B
//Cong tru: A, B cung sai
