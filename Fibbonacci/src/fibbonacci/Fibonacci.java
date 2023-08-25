/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibbonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kieup
 */
public class Fibonacci {

    public static void main(String[] args) {
        //Step 1: Find 45 sequence fibonacci 
        int[] arr = new int[45]; Gener(arr,0);
        //Step 2: Display 
        Display(arr);
    }

    private static int find45Fibonacci(int count, int prev, int curr) {
        if (count == 0) {
            return prev;
        } 
        else if(count == 1){ return curr;}
        else {return find45Fibonacci(count - 1,curr, prev + curr);}
    }
 
    private static void Gener(int[] arr, int count) {
    if (count == 0) {
        arr[count] = count;
    }
    if (count == 1) {
        arr[count] = count;
    }
    if (count > 1) {
        arr[count] = find45Fibonacci(count, 0, 1);
    }
    count++;
    if (count == arr.length) {
        return ;
    } else {
        Gener(arr, count);
    }
}
    private static void Display(int[] arr) {
        System.out.println("The 45 sequence fibonacci: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
               System.out.println(" f(" + i + ")= " + arr[i]);
        }

    }
}
