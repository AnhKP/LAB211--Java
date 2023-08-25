
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author windy
 */
public class BinarySearch {

    public static void main(String[] args) {
        //Step 1: User input number of array
        //int numOfArray = inputInt("Enter number of array:");

        //Step 2: User enter search value
        int searchValue = inputInt("Enter search value:");

        //Step 3: Generate random integer in number range
        //int[] array = generateArray(numOfArray);
        //int[] array = {1, 1, 1, 1, 3, 4, 6, 8, 9, 9};
        int[] array = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};

        //Step 4: Display sorted array
        displaySortedArray(array);

        //Step 5: Diplay index of search number
        displayIndexSearchNum(array, searchValue, true);
        //DisplayIndex(array, searchValue, true);
        //displayIndexSearchNum(array, 0, array.length-1, searchValue);
    }

    public static int inputInt(String str) {
        Scanner sc = new Scanner(System.in);
        //loop until user enter valid value
        while (true) {
            System.out.println(str);
            String input = sc.nextLine();
            //check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can't be empty!");
                continue;
            }
            try {
                int output = Integer.parseInt(input);
                //check if output is larger than 0 or not
                if (output <= 0) {
                    System.out.println("Input must be positive!");
                    continue;
                }
                return output;
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer!");
            }
        }
    }

    public static int[] generateArray(int numOfArray) {
        int[] array = new int[numOfArray];
        //loop until all number of array is generate
        for (int i = 0; i < numOfArray; i++) {
            array[i] = new Random().nextInt(numOfArray);
        }
        return array;
    }

    public static void displaySortedArray(int[] array) {
        //Loop through the first element to the last element of array, 
        //after one loop one element maximum is sorted in the last array
        for (int i = 0; i < array.length; i++) {
            //Loop through the first unsorted element to the second last unsorted element in array
            for (int j = 0; j < array.length - i - 1; j++) {
                //Compare two element stand side by side
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted array: [");
        //loop from the first to the last number of array to display array
        for (int i = 0; i < array.length; i++) {
            //check if the element is the last or not
            if (i == array.length - 1) {
                System.out.println(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
    
    
    public static void displayIndexSearchNum(int[] array, int searchValue, boolean test){
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int foundIndex = -1;
        int step = 0;
        
        while(leftIndex<= rightIndex){
            int midIndex = (leftIndex+rightIndex)/2;
            //Check search value is equal element in middle index or not 
            if(searchValue == array[midIndex]){
                foundIndex = midIndex;
//                step++;
//                if(test){
//                    displayTest(step, array, leftIndex, rightIndex, searchValue, " == ");
//                }
              break;
            } 
           //check search value is large than element in middle index or not
            else if (array[midIndex] < searchValue){
                
//                step++;
//                if(test){
//                    displayTest(step, array, leftIndex, rightIndex, searchValue, " < ");
//                }
                leftIndex = midIndex + 1;
            } else{
//                step++;
//                if(test){
//                    displayTest(step, array, leftIndex, rightIndex, searchValue, " > ");
//                }
                rightIndex = midIndex -1;
            }
        }
        // check foundIndex is equal than -1 or not 
        if(foundIndex == -1){
//            step++;
//            System.out.println("Step" + step + "(searched value is absent):");
            System.out.println("Not Found!");
        } else{
            System.out.println("Found " + searchValue + " at index: " + foundIndex);
        }
    }
    
    public static void displayTest(int step, int[] array, int leftIndex, int rightIndex, int searchValue, String status){
        int midIndex = (leftIndex+rightIndex)/2;
        System.out.print("Step " + step + " (middle element is " + array[midIndex] + status + searchValue + "):   ");
        //Loop use to access array
        for(int i=leftIndex; i<=rightIndex; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

}
