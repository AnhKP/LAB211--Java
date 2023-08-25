
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Loop until user choose exit program 
        while(true){
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            int choice = GetInput.getChoice("Please choice one option: ", 1, 3);
            switch(choice){
                case 1:
                    Calculator.NormalCaculator();
                    break;
                case 2: 
                    Calculator.BMI();
                    break;
                case 3: 
                    System.exit(0);
            }
        }
    }
    
}
