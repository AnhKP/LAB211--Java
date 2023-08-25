/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1.s.p0050;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Calculator {

    public static boolean checkEven(float input) {
        //check input is odd number or not
        if (input % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSquareNumb(float input) {
        //check input is square number or not
        if (input > 0) {
            if ((int) Math.sqrt(input) * (int) Math.sqrt(input) == input) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public static List<Float> Calculate(float a, float b){
        ArrayList<Float> cal = new ArrayList<>();
        cal.add(a);
        cal.add(b);
        if(a == 0){
            if(b == 0){
                System.out.println("Many solution");
            }
            else{
                System.out.println("No solution");
            }
        }
        else{
            float result = -b / a;
            System.out.println("Result: x = " + result);
            cal.add(result);
        }
        return cal;
    }
    
    public static void Display1(ArrayList<Float> cal){
         //Check Odds
        System.out.print("Odd numbers: ");
        boolean isFirstOdd = true;
        for (float num : cal) {
            if (!checkEven(num)) {
                if (!isFirstOdd) {
                    System.out.print(", ");
                }
                //check format of num to display
                if (num == (int) num) {
                    System.out.format("%.1f", num);
                } else {
                    System.out.format("%.2f", num);
                }
                isFirstOdd = false;
            }
        }
        System.out.println();
        System.out.print("Number Even is: ");
        boolean isFirstEven = true;
        for (float num : cal) {
            if (checkEven(num)) {
                if (!isFirstEven) {
                    System.out.print(", ");
                }
                                //check format of num to display
                if (num == (int) num) {
                    System.out.format("%.1f", num);
                } else {
                    System.out.format("%.2f", num);
                }
                isFirstEven = false;
            }
        }
        System.out.println();
        System.out.print("Number is PerfectSquare: ");
        boolean isFirstSquare = true;
        for (float num : cal) {
            if (checkSquareNumb(num)) {
                if (!isFirstSquare) {
                    System.out.print(", ");
                }
                //check format of num to display
                if (num == (int) num) {
                    System.out.format("%.1f", num);
                } else {
                    System.out.format("%.2f", num);
                }
                isFirstSquare = false;
            }
        }
        System.out.println();
    }

    public static List<Float> CalculateQuadraticEquation(float numb1, float numb2, float numb3) {
        ArrayList<Float> cal = new ArrayList<>();
        cal.add(numb1);
        cal.add(numb2);
        cal.add(numb3);
        if (numb1 == 0) {
            if (numb2 == 0) {
                if (numb3 == 0) {
                    System.out.println("Many solutions!");
                } else {
                    System.out.println("No solution!");
                }
            } else {
                float result = -numb3 / numb2;
                System.out.println("Solution: x = " + result);
                cal.add(result);
            }
        } else {
            float delta = numb2 * numb2 - 4 * numb1 * numb3;
            if (delta > 0) {
                float x1 = (float) ((-numb2 + Math.sqrt(delta)) / (2 * numb1));
                float x2 = (float) ((-numb2 - Math.sqrt(delta))) / (2 * numb1);
                System.out.printf("Solution: x1 = %.3f and x2 = %.3f%n", x1, x2);
                cal.add(x1);
                cal.add(x2);
            } else if (delta == 0) {
                float x1 = -numb2 / (2 * numb1);
                float x2 = x1;
                System.out.printf("Solution: x1 = %.3f and x2 = %.3f%n", x1, x2);
                cal.add(x1);
                cal.add(x2);
            } else {
                System.out.println("No real solutions!");
            }
        }      
    return cal;
    }
    public static void DisplayOddNumber(ArrayList<Float> cal, String str) {
        DecimalFormat df = new DecimalFormat("#.###");
        // Check Odds
        System.out.print(str);
        int count1 = -1;
        boolean isFirstOdd = true;
        for (float num : cal) {
            if (!checkEven(num)) {
                count1++;
                if (!isFirstOdd) {
                    System.out.print(", ");
                }
                  if (num == (int) num) {
                    System.out.format("%.1f", num);
                }
                 else{
                System.out.print(df.format(num));}
                isFirstOdd = false;
            }
        }
        if(count1 == - 1){
            System.out.println("No Odd Numbers!");
        }
        System.out.println();
    }
     public static void DisplayEvenNumber(ArrayList<Float> cal, String str) {
        DecimalFormat df = new DecimalFormat("#.###");
        // Check Evens
        System.out.print(str);
        boolean isFirstEven = true;
        int count2 = -1;
        for (float num : cal) {
            if (checkEven(num)) {
                count2++;
                if (!isFirstEven) {
                    System.out.print(", ");
                }
                 if (num == (int) num) {
                    System.out.format("%.1f", num);
                }
                 else{
                System.out.print(df.format(num));}
                isFirstEven = false;
            }
        }
        System.out.println();
        if(count2 == -1){
            System.out.println("No Even Number");
        }
     }
        // Check Perfect Squares
      public static void DisplayPerfectNumber(ArrayList<Float> cal, String str) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.print("Number is PerfectSquare: ");
        boolean isFirstSquare = true;
        int count3 = -1;
        for (float num : cal) {
            if (checkSquareNumb(num)) {
                count3++;
                if (!isFirstSquare) {
                    System.out.print(", ");
                }
                 if (num == (int) num) {
                    System.out.format("%.1f", num);
                }
                 else{
                System.out.print(df.format(num));}
                isFirstSquare = false;
            }
        }
        if(count3 == - 1){
            System.out.println("No Perfect Square Number!");
        }
        System.out.println();
    }
}