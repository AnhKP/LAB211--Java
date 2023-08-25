/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcaculator;

public class Caculator {

    public static int[][] additionTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] matrixresult = new int[rows][columns];
        //loop from the first row to the last row of the matrix
        for (int i = 0; i < matrix1.length; i++) {
            //loop from the first column to the last column of the matrix
            for (int j = 0; j < matrix1[0].length; j++) {
                matrixresult[i][j] = matrix1[i][j] + matrix2[i][j];
                //System.out.println(matrixresult[i][j]);
            }
        }
        return matrixresult;
    }

    public static int[][] subtractionTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] matrixresult = new int[rows][columns];
        //loop from the first row to the last row of the matrix
        for (int i = 0; i < rows; i++) {
            //loop from the first element of column to the last element of column of the matrix
            for (int j = 0; j < columns; j++) {
                matrixresult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixresult;
    }

    public static int[][] multipleTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        int[][] matrixresult = new int[rows1][columns2];
        //loop from the first row to the last row of the matrix1
        for (int i = 0; i < rows1; i++) {
            //loop from the first element of column to the last element of column of the matrix2
            for (int j = 0; j < columns2; j++) {
                //loop from the first row to the last row of the matrix2
                for (int k = 0; k < rows2; k++) {
                    matrixresult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixresult;
    }
}
