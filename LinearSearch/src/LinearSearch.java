
import java.util.Random;
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
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //1. User enter a positive number decimal
        int inputPosNumb = InputPosNumb("Enter number of array:");
        //Step 2: input a positive decimal number
        int searchValue = InputPosVal("Enter search value: ");
        //2. Create array by generate random integer in range
        int[] arr = GenerateArr(inputPosNumb);
        //3. Display array
        Display(arr, "The array: ");
        //5. Display the index of search number in array
        DisplayIndexOfSearchNumbbyLinerSearch(arr, searchValue);
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
          private static int InputPosVal(String s){
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
                if(posNumb < 0){
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
        if(str.equals("The array: ")){
            System.out.println("]");
        }
    }
    private static int searchByLinearSearch(int[] arr, int searchvalue){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == searchvalue){
               return i;
            }
        }
        return -1;
    }
 
    private static void  DisplayIndexOfSearchNumbbyLinerSearch(int[] arr, int searchValue){
//         int result = searchByLinearSearch(arr,searchValue);
//         if(result == - 1){
//             System.out.println("Not Found!");
//        }
//         else{
//             System.out.println("Found " + searchValue + " at index " + result);
//         }
       for(int i = 0; i < arr.length; i++){
           if(arr[i] != searchValue){// check searchvalue is 
               if(i == arr.length - 1){//
                   System.out.println("The number " + arr[i] + " at index " + i + " is not equal search value, exit");
                   System.out.println("Not Found!");
                   break;
           }
           System.out.println("The number " + arr[i] + " at index " + i + " is not equal search num, next");
           }else{
               System.out.println("The number " + arr[i] + " at index " + i + " is equal search num, exit.");
               break;
           }
       }
    }
}
