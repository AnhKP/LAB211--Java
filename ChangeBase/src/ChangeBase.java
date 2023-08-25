
import java.math.BigInteger;
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
public class ChangeBase {

   
    public static void main(String[] args) {
        // TODO code application logic here
        //Step 1: Display menu chose base;
        int baseIn = BaseIn("Your choice: ");
        //Step 2: Choose base want to convert; 
        int baseOut = BaseOut("Your choice: ", baseIn);
        //Step 3: Enter the input value;
        String inputValue = getInputValue(baseIn);
        //Step 4: Convert from base in to base out 
        String resultofconvert = Convert(baseIn,baseOut, inputValue);
        //Step 5: Display result 
        Displayresult(resultofconvert);
        
    }

    private static int BaseIn(String str) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu\n1.Binary\n2.Decimal\n3.Hexcimal\n4.Exit");
            System.out.print(str);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input is not empty");
                continue;
            }
            try{
                int baseIn = Integer.parseInt(input);
                //check if valid base in is valid 
                if(baseIn < 1 || baseIn > 3){
                    System.out.println("Please enter again!!");
                    continue;
                }
                return baseIn;
            }catch(NumberFormatException ex){              
            }
        }
    }

    private static int BaseOut(String str, int baseIn) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu\n1.Binary\n2.Decimal\n3.Hexcimal");
            System.out.print(str);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input is not empty");
                continue;
            }
             try{
                int baseOut = Integer.parseInt(input);
                //check if valid base in is valid 
                if((baseOut < 1 || baseOut > 3) && baseOut == baseIn){
                    System.out.println("Please enter again!!");
                    continue;
                }
                return baseOut;
            }catch(NumberFormatException ex){              
            }
        }
    }

    private static String getInputValue(int baseIn) {
        Scanner sc = new Scanner(System.in);
        String inputValue = new String();
        switch (baseIn) {
            case 1:
                do{
                    System.out.print("Enter input value of base Binary: ");
                    inputValue = sc.nextLine();
                    if (inputValue.isEmpty()) {
                        System.out.println("Input is not empty");
                        continue;
                    } else {
                        if (!inputValue .matches("^[01]+$")) {
                            System.out.println("Input wrong format of Binary!!");
                            continue;
                        } else {
                            break;
                        }
                    }
                }while(true);
                break;
            case 2:
                  do{
                    System.out.print("Enter input value of base Decimal: ");
                    inputValue = sc.nextLine();
                    if (inputValue.isEmpty()) {
                        System.out.println("Input is not empty");
                        continue;
                    } else {
                        if (!inputValue.matches("^[0-9]+$")) {
                            System.out.println("Input wrong format of Decimal!!");
                            continue;
                        } else {
                            break;
                        }
                    }
                }while(true);
                  break;
            case 3: 
                  do{
                    System.out.print("Enter input value of base Hexcimal: ");
                    inputValue = sc.nextLine();
                    if (inputValue.isEmpty()) {
                        System.out.println("Input is not Empty");
                        continue;
                    } else {
                        if (!inputValue.matches("^[0-9A-Fa-f]+$")) {
                            System.out.println("Input wrong format of Hexcimal!!");
                            continue;
                        } else {
                            break;
                        }
                    }
                }while(true);
                  break;
        }
        return inputValue;
    }

    private static String Convert(int baseIn, int baseOut, String inputValue) {
            String result;
            String Dec = convertFromOtherBaseToDec(baseIn, inputValue);
            result = convertFromDecToOtherBase(baseOut, inputValue);
            return result;
            
    }

    private static String convertFromDecToOtherBase(int baseOut, String inputValue) {
        BigInteger dec = new BigInteger(inputValue);
        BigInteger zero = new BigInteger("0");
        StringBuilder result = new StringBuilder();
        switch(baseOut){
           case 1:
               //do when input value after convert to dec num not equal to 0 
               while(dec.compareTo(zero) != 0){
                   BigInteger[] remain = dec.divideAndRemainder(BigInteger.valueOf(2));
                   result.append(remain[1]);
                   dec = remain[0];
               }
               break;
           case 2: //FromDecToDec
               String decimal = dec.toString();
               char[] digit = decimal.toCharArray();
                //loop use to take position of each digit from char array from last to first
                for (int i = decimal.length() - 1; i >= 0; i--) {
                    result.append(digit[i]);
                }
               break;
           case 3: //FromDectoHex
              while(dec.compareTo(zero) != 0){
                  BigInteger remain = dec.mod(BigInteger.valueOf(16));
                    //check if remainder is a number from 0 to 9
                    if (remain.intValue() >= 0 && remain.intValue() <= 9) {
                        result.append(remain.toString());
                    } else {
                        switch (remain.intValue()) {
                            case 10:
                                result.append('A');
                                break;
                            case 11:
                                result.append('B');
                                break;
                            case 12:
                                result.append('C');
                                break;
                            case 13:
                                result.append('D');
                                break;
                            case 14:
                                result.append('E');
                                break;
                            case 15:
                                result.append('F');
                                break;
                        }
                    }
                    dec = dec.divide(BigInteger.valueOf(16));
                }
                break;
        }
        return result.reverse().toString();
       }

    private static String convertFromOtherBaseToDec(int baseIn, String InputValue) {
         BigInteger Dec = BigInteger.ZERO;
        switch(baseIn){
            case 1:
                BigInteger ValueInput = new BigInteger(InputValue);
                BigInteger base = BigInteger.valueOf(2);
                //loop us to take index of each digit from last to first
                for (int i = 0; i < InputValue.length(); i++) {
                    BigInteger[] divide = ValueInput.divideAndRemainder(BigInteger.TEN);
                    Dec = Dec.add(divide[1].multiply(base.pow(i)));
                    ValueInput = divide[0];
                }
                break;
            case 2:
                BigInteger Value10 = new BigInteger(InputValue);
                return Value10.toString();
            case 3:
                int j = 0;
                int digitValue;
                BigInteger base16 = BigInteger.valueOf(16);
                // loop use to take value index of each digit from first to last
                for (int i = InputValue.length() - 1; i >= 0; i--) {
                    digitValue = Character.getNumericValue(InputValue.charAt(i));
                    Dec = Dec.add((BigInteger.valueOf(digitValue).multiply(base16.pow(j))));
                    j++;
                }
        }
        return Dec.toString();
        
    }
        
    public static void Displayresult(String result) {
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("Result: " + result);
        System.out.println();
        do {
            System.out.print("Do you want to continue (Y/N): ");
            choice = sc.nextLine();
        } while (choice.isEmpty() == true || !choice.matches("^[YN]{1}$"));
        switch (choice) {
            case "Y" :
                int baseIn = BaseIn("Your choice: ");
                int baseOut = BaseOut("Your choice: ", baseIn);
                String inputValue = getInputValue(baseIn);
                String resul = Convert(baseIn, baseOut, inputValue);
                Displayresult(resul);
                break;
            case "N":
                System.out.println("Exit program");
                break;
        }

    }
}

