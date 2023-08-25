
package doctormanagement;

import java.util.Scanner;

public class getInput {
        public int getInteger(Scanner sc, String msg, int min, int max){
        String input;
        int intnumb = -1;
        do{
            System.out.println(msg);
            input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Input can not be empty!!");
                continue;
            }
        try{
            intnumb = Integer.parseInt(input);
            //check intnumb in rage min and max
            if(intnumb < min || intnumb > max ){
                System.out.println("Inpur in range" + min + "and" + max);
                continue;
            }
            else{
                break;
            }
        } catch(NumberFormatException ex){
            System.out.println("Input muse be integer");
        }
        }while(true);
        return intnumb;
    }
         public int getInputChoice(Scanner sc, String msg, int min, int max){
        String input;
        int intnumb = -1;
        do{
            System.out.println(msg);
            input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Input can not be empty!!");
                continue;
            }
        try{
            intnumb = Integer.parseInt(input);
            //check intnumb in rage min and max
            if(intnumb < min || intnumb > max ){
                System.out.println("Inpur in range" + min + "and" + max);
                continue;
            }
            else{
                break;
            }
        } catch(NumberFormatException ex){
            System.out.println("Input muse be integer");
        }
        }while(true);
        return intnumb;
    }
    public String getString(Scanner sc, String msg, String pattern) {
        String input;
        boolean cont = false;
        do {
            System.out.print(msg);
            input = sc.nextLine();
              if(input.trim().isEmpty()){
                System.out.println("Input can not be empty!!");
                continue;
            }
            try {
                if (!input.matches(pattern)) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                cont = true;
            }
        } while (cont);
        return input;
    }
}
