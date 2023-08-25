
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

    public static double getInput(String msg) {
        Scanner sc = new Scanner(System.in);
        //Loop use to input valid 
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is empty or not
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                Double output = Double.parseDouble(input);
                return output;
            } catch (NumberFormatException e) {
                System.out.println("Input must be valid numbers");
            }
        }
    }

    public static String getOperator(String str) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(str);
            String operator = sc.nextLine();
            if (operator.matches("[+\\-*/^/=]")) {
                return operator;
            } else {
                System.out.println("Please enter a valid operator (+, -, *, /, ^).");
            }
        }
    }
       public static double getInputBMI(String msg) {
        Scanner sc = new Scanner(System.in);
        //Loop use to input valid 
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is empty or not
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                Double output = Double.parseDouble(input);
                if(output <= 0){
                    System.out.println("Input must be large than 0");
                    continue;
                }
                return output;
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
    }
}
