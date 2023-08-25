/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_bubblesort;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author kieup
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Enter a positive decimal number of array
        String s  = InputInt();
        //2. Create array
//       int[] arr = createArray(numbOfArray);
//       // int[] arr = {5, 1, 12, -5, 16};
//        //3. Display array before sort
//        Display(arr, "Unsorted array: ");
//        //4. Sort array by Bubble sort
//        BubbleSort(arr);
//        //5. Display array after sort
//        Display(arr, "Sorted array: ");
    }

    private static String InputInt() {
        Scanner sc = new Scanner(System.in);
        String input;
        //loop until user enter valid value
        while (true) {
            System.out.println("Input: ");
            input = sc.nextLine();
           if(input.matches("[0-9]+")){
               if(input.length() == 10){
                   break;
               }
               else{
                   System.out.println("Input must have exactly 10 digit");
               }
           }
           else if(input.matches("[A-Za-z]+")){
              System.out.println("You have to be digit.");
                
               }
           else{
                   System.out.println("You have to be digit doesn't include letter.");
               }
        }
        return input;
    }

    public static int[] createArray(int numbOfArray) {
        int[] arr = new int[numbOfArray];
        Random random = new Random();
        //Loop use to random each element of array
        for (int i = 0; i < numbOfArray; i++) {
            arr[i] = random.nextInt(numbOfArray);
        }
        return arr;
    }

    public static void Display(int[] arr, String msg) {
        System.out.print(msg);
        System.out.print("[");
        //Loop use to accessed each element of array and display
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            //Check index and insert , after elements 
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        //Check if string msg equal or other string 
        if (msg.equals("Unsorted array: ")) {
            System.out.println("]");
        } else {
            System.out.print("]");
        }
    }

    public static void BubbleSort(int[] arr ) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
               
                if (arr[j] > arr[j + 1]) {
                        Display(arr, "");
                        System.out.println("   " + arr[j] + ">" + arr[j + 1] + "," + "swap");
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                } else {
                    Display(arr, "");
                    System.out.println("   " + arr[j] + "<" + arr[j + 1] + "," + "ok");
                }
            }
        }
    }
}
