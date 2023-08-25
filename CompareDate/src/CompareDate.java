
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CompareDate {
    public static void main(String[] args) {
        // TODO code application logic here
        //Step 1:  Input first date with [dd/mm/yyyy] format 
        Date firstDate = InputFirstDateWithFormat("Please enter the first date: ");
        //Step 2:  Input second date with [dd/mm/yyyy] format
        Date secondDate = InputSecondDateWithFormat("Please enter the second date: ");
        //Step 3: Compare two date
        int result = CompareTwoDate(firstDate, secondDate);
        //Step 4: Display result of compare two date
        DisplayResultOfCompareTwoDate(result);
    }
    private static Date InputFirstDateWithFormat(String str) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        //Loop use to check input is valid correct with dd/mm/yyy format 
        while (true) {
            System.out.print(str);
            String input = sc.nextLine();
            //Check input is empty or not 
            if (input.isEmpty()) {
                System.out.println("Please input cannot be empty!");
                continue;
            }
            //Check input is correct with dd/mm/yyyy format or not
            //\d: all digits 0-9
            // \d{1,2} : may contains 1 or 2 digits
            // \d{1,4}: may contains 1 or 4 digits
            //[/] : matches with sign "/"
            if (!(input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{1,4}"))) {
                System.out.println("Wrong format! Please enter the date with [dd/mm/yyyy] format!");
                continue;
            }
            try {
                dateformat.setLenient(false);
                Date date = dateformat.parse(input);
                return date;
            } catch (ParseException e) {
                System.out.println("This date doesn't exist!");
            }
        }
    }
    private static Date InputSecondDateWithFormat(String str) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        //Loop use to check input is valid correct with dd/mm/yyy format 
        while (true) {
            System.out.print(str);
            String input = sc.nextLine();
            //Check input is empty or not 
            if (input.isEmpty()) {
                System.out.println("Please input cannot be empty!");
                continue;
            }
            //Check input is correct with dd/mm/yyyy format or not
            //\d: all digits 0-9
            // \d{1,2} : may contains 1 or 2 digits
            // \d{1,4}: may contains 1 or 4 digits
            //[/] : matches with sign "/"
            if (!(input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{1,4}"))) {
                System.out.println("Wrong format! Please enter the date with [dd/mm/yyyy] format!");
                continue;
            }
            try {
                dateformat.setLenient(false);
                Date date = dateformat.parse(input);
                return date;
            } catch (ParseException e) {
                System.out.println("This date doesn't exist!");
            }
        }
    }
    private static int CompareTwoDate(Date firstDate, Date secondDate) {
        int result = 0;
        //Check firstDate is large than secondDate or not
        if (firstDate.compareTo(secondDate) < 0) {
            return result = 1;
        } //Check firstDate is large than secondDate or not
        else if (firstDate.compareTo(secondDate) > 0) {
            return result = -1;
        } else {
            return result;
        }
    }
    private static void  DisplayResultOfCompareTwoDate(int result) {
        System.out.println();
        //Check result 
        if (result == 1) {
            System.out.println("Date 1 is before Date2");
        } else if (result == -1) {
            System.out.println("Date 1 is after Date2");
        } else {
            System.out.println("Date 1 is equal Date2");
        }
    }
}
