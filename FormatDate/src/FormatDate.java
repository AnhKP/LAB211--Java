
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
public class FormatDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here/
        //Step 1: Enter date
        Date date = InputDate("Enter the date: ");
        //Step 2: Display Day of Date
        DisplayDayofDate(date);
    }
     private static Date InputDate(String str) {
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


    private static void DisplayDayofDate(Date date) {
       SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
       String dayofWeek = dayFormat.format(date);
       System.out.println("The day is:" + dayofWeek);  
    }


}
