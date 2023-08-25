/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kieup
 */
class Menu {

   public static void DisplayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

   public static void DisplayResult(int[][] matrix1, int[][] matrix2, int[][] matrixresult, int choice) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        switch (choice) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(matrixresult);
    }

   public static void displayMatrix(int[][] matrix) {
        //loop from the first row to the last row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            //loop from the first element of column to the last element of column of the matrix
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] +"]");
            }
            System.out.println();
        }
    }
    public static void printTitleOfOption(int choice){
        switch(choice){
            case 1:
                System.out.println("-------- Addition --------");
                break;
            case 2:
                System.out.println("----- Subtraction ------");
                break;
            case 3:
                System.out.println("-------- Multiplecation --------");
        }
}

}
