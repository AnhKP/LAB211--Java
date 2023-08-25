
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    public static int getInteger(Scanner sc, String msg, int min, int max) {
        String input;
        int intnumb = -1;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                intnumb = Integer.parseInt(input);
                //check intnumb in rage min and max
                if (intnumb < min) {
                    System.out.println("Input must be integer lager than 0!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Input muse be integer");
            }
        } while (true);
        return intnumb;
    }
    public static Double getDouble(Scanner sc, String msg, int min, int max) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                double numb = Double.parseDouble(input);
                //check intnumb in rage min and max
                if (numb < min) {
                    System.out.println("Input must be integer lager than 0!");
                    continue;
                } 
            return numb;
            } catch (NumberFormatException ex) {
                System.out.println("Input muse be integer");
            }
        } while (true);      
    }
    

    public static int getChoice(Scanner sc, String msg, int min, int max) {
        String input;
        int intnumb = -1;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                intnumb = Integer.parseInt(input);
                //check intnumb in rage min and max
                if (intnumb < min || intnumb > max) {
                    System.out.println("Inpur in range " + min + " and " + max);
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Input muse be integer");
            }
        } while (true);
        return intnumb;
    }
    public static String getString(Scanner sc, String msg, String pattern) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                if (!input.matches(pattern)) {
                    continue;
                }
                return input;
            } catch (Exception e) {
            }
        }
    }

    public static Date getDate(Scanner sc, String msg) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Loop use to check input is valid correct with dd/mm/yyy format 
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            dateFormat.setLenient(false);
            if (input.isEmpty()) {
                System.out.println("Input can not be empty!!");
                continue;
            }
            //Check input is correct with dd/mm/yyyy format or not
            //\d: all digits 0-9
            // \d{1,2} : may contains 1 or 2 digits
            // \d{1,4}: may contains 1 or 4 digits
            //[/] : matches with sign "/"
            if (!(input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}"))) {
                System.out.println("Input is wrong format");
                continue;
            }
            try {
                Date date = dateFormat.parse(input);
                LocalDate parsedDate = LocalDate.of(
                        date.getYear() + 1900,
                        date.getMonth() + 1,
                        date.getDate()                  
                );
                LocalDate currentDate = LocalDate.now();
                Period period = Period.between(parsedDate, currentDate);
                //Check period is smaller than 18 or not 
                if (period.getYears() < 18) {
                    System.out.println("Date is at least 18 years ago. Please enter again");
                } else if (period.getYears() >= 65) {
                    System.out.println("Date is too larger. Please enter again");
                } else {
                    String formattedDate = dateFormat.format(date);
                    return dateFormat.parse(formattedDate);
                }
            } catch (ParseException e) {
                System.out.println("Date doesn't existed!!");
            }
        }
    }
}
