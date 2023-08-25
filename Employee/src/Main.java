
import java.text.ParseException;
import java.util.ArrayList;
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
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int choice;
        GetInput input = new GetInput();
        Display display = new Display();
        ManageEmployee manage = new ManageEmployee();
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        //Loop to until user choose exit program
        do {
            //1. Display a menu
            display.DisplayMenu();
            //2. Get user's choice
            choice = input.getChoice(sc, "Let's option choice: ", 1, 6);
            switch (choice) {
                case 1:
                    manage.addEmployee(EmployeeList);
                    break;
                case 2:
                    manage.updateEmployeebyId(EmployeeList);
                    break;
                case 3:
                    manage.removeEmployee(EmployeeList);
                    break;
                case 4:
                    manage.searchEmployeeByName(EmployeeList);
                    break;
                case 5:
                    manage.sortEmployeesBySalary(EmployeeList);
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);

    }
}
