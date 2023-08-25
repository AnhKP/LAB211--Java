/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1.s.p0050;

import java.util.Scanner;

public class GetInput {
   public static int getChoice(String msg, int min, int max) {
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
                    System.out.println("Inpur in range " + min + " and " + max);
                    continue;
                }
                return choice;
            } catch (NumberFormatException ex) {
                System.out.println("Input muse be integer!!");
            }
        }
   }
  
  public static float getInput1(String msg){
    Scanner sc = new Scanner(System.in);
    //Loop use to input valid 
    while(true){
        System.out.println(msg);
        String input = sc.nextLine();
        //Check input is empty or not
        if(input.isEmpty()){
            System.out.println("Input can not be empty!!");
            continue;
        }
        try{
            Float output = Float.parseFloat(input);
            return output;
        }catch(NumberFormatException e){
            System.out.println("Input must be valid numbers");
        }
    }
  }
   public static float getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        float value;
        while (true) {
            System.out.print(message);
            try {
                value = Float.parseFloat(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    } 
}
