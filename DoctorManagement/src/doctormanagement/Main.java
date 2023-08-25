
package doctormanagement;

import java.util.HashMap;
import java.util.Scanner;
public class Main{

    public static void main(String[] args) throws Exception {
        // TODO code application logic hereS
        Scanner sc =  new Scanner(System.in);
        Display display = new Display();
        getInput getinput = new getInput();
        Doctor doctor1 = new Doctor();
        //Display Menu 
        display.DisplayMenu();
        //Loop use to check user'choice 
        while(true){
            int choice = getinput.getInputChoice(sc,"Your choice: ", 1,5);
            //
            switch(choice){
                //Step 1: Add doctor
                case 1: 
                    System.out.println("--------- Add Doctor ----------");
                    doctorHash.addDoctor(doctor1);
                    break;
                //Step 2:Update Doctor
                case 2: 
                    System.out.println("--------- Update Doctor -------");
                    doctorHash.updateDoctor(doctor1);
                    break;
                //Step 3: Delete Doctor
                case 3:
                    System.out.println("--------- Delete Doctor -------");
                    doctorHash.deleteDoctor(doctor1);
                    break;
                //Step 4: Search Doctor
                case 4:
                    System.out.println("---------- Search Doctor --------");
                    String input = getinput.getString(sc, "Enter search term: ", "^[A-Za-z]+$");
                    HashMap<String, Doctor> searchResult = doctorHash.searchDoctor(input);
                    if (searchResult.size() > 0) {
                        break;
                    } else {
                        System.out.println("No doctors found!");
                    }
                    break;
                case 5: 
                    display.printAllDoctors(doctorHash.getDoctorDB());
                    System.exit(0);
            }
        }
   } 
}
