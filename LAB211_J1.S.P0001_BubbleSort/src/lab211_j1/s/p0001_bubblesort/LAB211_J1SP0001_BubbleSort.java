/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1.s.p0001_bubblesort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kieup
 */
public class LAB211_J1SP0001_BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        //Step 1: Enter a positive decimal number 
//        int inputPosNumb = InputPosNumb("Enter a positive decimal number: ");
//        //Step 2: Generate array 
//        int arr[] = GenerateArr(inputPosNumb);
        int[] arr = {5, 1, 12, -5, 16};
        //Step 3: Display array before unsorted array
        Display(arr, "Unsorted array: ");
        //Step 4: Sorted array by Bublle Sort
        BubbleSort(arr);
        //Step 5: Display sorted array
        Display(arr, "Sorted array: ");
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
        //Loop use to accessed each element of array and display 
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]);
            //Check index and insert ',' after elements 
            if(i < arr.length - 1){
                System.out.print(",");
        }
    }
        //Check str to insert ] last arr
        if(str.equals("Unsorted array: ")){
            System.out.println("]");
        }
        else{
            System.out.print("]");
        }
    }
    private static void BubbleSort(int[] arr){
        /*Loop use to accessed from the first to last element of arraay, after 
        each loop, one element is sorted*/
        /*Vòng lặp sử dụng để truy cập từ phần tử đầu tiên đến 
        phần tử cuối cùng của mảng, sau mỗi vòng lặp, một phần tử được sắp xếp*/
        
        for(int i = 0; i < arr.length; i++){
           /*Loop usr to accessed first unsorted element to the element stand 
            before the last unsorted elements */
             /*Lặp sử dụng để truy cập phần tử chưa sắp xếp đầu tiên 
             đến phần tử đứng trước phần tử chưa sắp xếp cuối cùng */
           for(int j = 0; j <  arr.length - i - 1; j++){
               //compare each pair adjacent elements 
               if (arr[j] > arr[j + 1]) {
                        Display(arr, "");
                        System.out.println("   " + arr[j] + ">" + arr[j + 1] + "," + "swap");
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                } else {
                    Display(arr, "");
                    System.out.println("  " + arr[j] + "<" + arr[j + 1] + "," + "ok");
                }
           }
           System.out.println();
        }
    }
}
