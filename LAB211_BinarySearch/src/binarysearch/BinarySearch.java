/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kieup
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // TODO code application logic here
      //1. User enter a positive number decimal
       // int inputPosNumb = InputPosNumb("Enter number of array:");
        //Step 2: input a positive decimal number
        int searchValue = InputPosNumb("Enter search value: ");
        //2. Create array by generate random integer in range
        //int[] arr = GenerateArr(inputPosNumb);
        int[] arr = {1, 1, 1, 1, 3, 4, 6, 8, 9, 9};
      //  int[] array = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
        //3. Display sorted array
        Display(arr, "The array: ");
        //Step 4:
        int index = BinarySearch(arr,0,arr.length-1,searchValue);
        //5. Display the index of search number in array
        displayIndexSearchNum(index, searchValue);    
     }
     private static int InputPosNumb(String s){
        Scanner sc = new Scanner(System.in);
        //Loop to user enter valid input postive number 
        while(true){
            System.out.println(s);
            String InputPosNumb = sc.nextLine();
            //check if inputposnumb is empty 
            if(InputPosNumb.isEmpty()){
                System.out.println("Input can't empty!!");
                continue;
            }
            try {
                int posNumb = Integer.parseInt(InputPosNumb);
                //check input is large than 0 or not 
                if(posNumb <= 0){
                    System.out.println("Input must be a positive decimal number!");
                    continue;
                }
                return posNumb;
            }
            catch(NumberFormatException e){
                System.out.println("Input must be a positive decimal number!");
            }
        }
    }
      private static int[] GenerateArr(int inputPosNumb){
        int[] arr = new int[inputPosNumb];
        Random random = new Random();
        //Loop use to random each element of array
        for(int i = 0; i < inputPosNumb; i++){
            arr[i] = random.nextInt(inputPosNumb);
        }
        return arr;
    }
    
    private static void Display(int[] arr, String str){
        System.out.print(str);
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++)
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        //Loop use to accessed each element of array and display 
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]);
            //Check index and insert ',' after elements 
            if(i < arr.length - 1){
                System.out.print(",");
        }
    }
        if(str.equals("The array: ")){
            System.out.println("]");
        }
    }
    private int BinarySearch(int arr[], int leftIndex, int rightIndex, int searchValue){
     int step = 0;
        while(leftIndex<= rightIndex){
            int midIndex = (leftIndex+rightIndex)/2;
            if(searchValue == arr[midIndex]){     
                step++;
                displayTest(step, arr, leftIndex, rightIndex, searchValue, " == ");  
                return midIndex;
            } else if (arr[midIndex]<searchValue){
                step++;
                displayTest(step, arr, leftIndex, rightIndex, searchValue, " < ");
                leftIndex = midIndex + 1;
            } else{
                step++;
                displayTest(step, arr, leftIndex, rightIndex, searchValue, " > ");
                rightIndex = midIndex -1;
            }
        }
       return -1;
    }
    
private static void displayIndexSearchNum(int index, int searchValue){ 
        if(index == -1){
            System.out.println("Not found!");
        } else{
            System.out.println("Found " + searchValue + " at index: " + index);
        }
    }
    public static void displayTest(int step, int[] array, int leftIndex, int rightIndex, int searchValue, String status){
        int midIndex = (leftIndex+rightIndex)/2;
        System.out.print("Step " + step + " (middle element is " + array[midIndex] + status + searchValue + "):   ");
        for(int i=leftIndex; i<=rightIndex; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
