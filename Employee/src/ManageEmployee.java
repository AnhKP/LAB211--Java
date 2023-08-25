
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class ManageEmployee {

    GetInput input = new GetInput();
    Display display = new Display();
    Scanner sc = new Scanner(System.in);

    public boolean checkDuplicateID(int Id, ArrayList<Employee> EmployeeList) {
        boolean isExist = false;
        if (EmployeeList.isEmpty()) {
            return isExist;
        } else {
            //Loop use to access from first to last list
            for (int i = 0; i < EmployeeList.size(); i++) {
                //Compare ID from input and each ID of employee has in EmployeeList
                if (Id == EmployeeList.get(i).getId()) {
                    System.out.println("ID existed!!");
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    //Add item 
    public void addEmployee(ArrayList<Employee> EmployeeList) throws ParseException {
        int Id;
        //Check List is empty or not 
        if (EmployeeList.isEmpty()) {
            System.out.println("List doesn't exist");
        } else {
            display.DisplayList(EmployeeList);
        }
        //Loop use to check ID 
        while (true) {
            Id = input.getInteger(sc, "Enter the employee's ID: ", 1, Integer.MAX_VALUE);
            boolean isExist = checkDuplicateID(Id, EmployeeList);
            //check id from input is duplicate with id of each employee in employeelist 
            if (isExist == true) {
                continue;
            } else {
                break;
            }
        }
        //^: start
        //+: more than one 
        //$: end 
        //[a-zA-Z]: contains any character from a to z or A to Z.
        String firstname = input.getString(sc, "Enter first name of employee: ", "^[a-zA-Z]+$");
        //^: start
        //+: more than one 
        //$: end 
        //[a-zA-Z]: contains any character from a to z or A to Z.
        String lastname = input.getString(sc, "Enter last name of employee: ", "^[a-zA-Z]+$");
        // ^0: start with digit 0
        //\d{9}: a string need 9  number
        //$: end
        String phone = input.getString(sc, "Enter phonenumber of employee: ", "^0\\d{9}$");
        //^: start
        //+: more than one 
        //$: end 
        //[A-Za-z0-9]: must be contains character from a to z or A to Z or digit from 0 to 9
        // +: more than one character or digit 
        // @: must be chacracter @ 
        //[.]: must be character.
        //[A-Za-z]{2,6}: must be contains from 2 to 6 characters.
        //[A-Za-z]{2,3}: must be contains from 2 to 3 characters.
        String email = input.getString(sc, "Enter the email of employee: ", "^[A-Za-z0-9]+@[A-Za-z]{3,6}+[.][A-Za-z]{2,3}");
        //[A-Za-z]: must be contains character A-Z and a-z 
        // \s : matches with space
        //+: more than one charater or digit , ^: start string, $: end 
        String address = input.getString(sc, "Enter the address of employee: ", "^[[A-Za-z]\\s]+$");
        Date dob = input.getDate(sc, "Enter the birthday of employee[dd/MM/yyyy]: ");
        //{FM}{1}: must have only one character 'F' or character 'M'
        String sex = input.getString(sc, "Enter the gender of employee[F: female; M: male]: ", "[FM]{1}");
        double salary = input.getDouble(sc, "Enter the salary of employee: ", 1, Integer.MAX_VALUE);
        //[A-Za-z]:  must be contains character from a to z or A to Z
        // \s : matches with space
        //+: more than one charater or digit ,
        //^: start 
        //$: end 
        String agency = input.getString(sc, "Enter the agency: ", "^[[A-Za-z]\\s]+$");
        Employee employee = new Employee(Id, firstname, lastname, phone, email, address, dob, sex, salary, agency);
        EmployeeList.add(employee);
        display.DisplayList(EmployeeList);
    }

    int findID(ArrayList<Employee> EmployeeList, int id) {
        int index = -1;
        //Check list is empty or not 
        if (EmployeeList.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            //loop use to access from first to last list
            for (int i = 0; i < EmployeeList.size(); i++) {
                //Compare id input and each id of employee has in list
                if (id == EmployeeList.get(i).getId()) {
                    index = EmployeeList.indexOf(EmployeeList.get(i));
                    break;
                }
            }
        }
        return index;
    }

    void updateEmployeebyId(ArrayList<Employee> EmployeeList) throws ParseException {
        int Id;
        int index;
        //Loop use to valid input
        while (true) {
            display.DisplayList(EmployeeList);
            Id = input.getInteger(sc, "Enter the employee's ID: ", 1, Integer.MAX_VALUE);
            index = findID(EmployeeList, Id);
            //Check ID is in EmployeeList or not 
            if (index == -1) {
                System.out.println("Can not find employee!!Please re-enter!!");
                continue;
            } else {
                break;
            }
        }
        //Loop use to update element
        do {
            System.out.println("Choose update option:");
            System.out.println("1. Update Id of emloyee");
            System.out.println("2. Update first name of employee");
            System.out.println("3. Update lastname of employee");
            System.out.println("4. Update phone number of employee");
            System.out.println("5. Update email of employee");
            System.out.println("6. Update address of employee");
            System.out.println("7. Update birthday of employee");
            System.out.println("8. Update gender of employee");
            System.out.println("9. Update salary of employee");
            System.out.println("10. Update agency of employee");
            int choice = input.getChoice(sc, "Your choice: ", 1, 10);
            switch (choice) {
                case 1:
                    do {
                        int ID = input.getInteger(sc, "Enter employee's id: ", 1, Integer.MAX_VALUE);
                        int newposID = -1;
                        //loop use to access from first to last of employee list 
                        for (int i = 0; i < EmployeeList.size(); i++) {
                            //check position i to skip case position of empoyee is updating
                            if (i == index) {
                                continue;
                            } else {
                                //check ID is valid in list (except its ID) or not
                                if (EmployeeList.get(i).getId() == ID) {
                                    newposID = i;
                                }
                            }
                        }
                        //Check ID after update is duplicated or not 
                        if (newposID == -1) {
                            EmployeeList.get(index).setId(ID);
                            break;
                        } else {
                            System.out.println("ID is exist");
                        }
                    } while (true);
                    break;
                case 2:
                    //^: start
                    //+: more than one 
                    //$: end 
                    //[a-zA-Z]: match any character from a to z or A to Z.
                    String firstname = input.getString(sc, "Enter first name of employee: ", "^[a-zA-Z]+$");
                    EmployeeList.get(index).setFirstName(firstname);
                    break;
                case 3:
                    //^: start
                    //+: more than one 
                    //$: end 
                    //[a-zA-Z]: match any character from a to z or A to Z.
                    String lastname = input.getString(sc, "Enter last name of employee: ", "^[a-zA-Z]+$");
                    EmployeeList.get(index).setLastName(lastname);
                    break;
                case 4:
                    // ^0: start with digit 0
                    //\d{9}: a string need 9  number
                    //$: end
                    String phone = input.getString(sc, "Enter phonenumber of employee", "^0[123456789]{1}\\d{8}$");
                    EmployeeList.get(index).setPhone(phone);
                    break;
                case 5:
                    //^: start
                    //+: more than one 
                    //$: end 
                    //[a-zA-Z0-9]: match any character from a to z or A to Z or digit from 0 to 9
                    // +: more than one character or digit 
                    // @: must have be chacracter @ in email 
                    //\.: match character
                    //[a-zA-Z]{2,6}: must have from 2 to 6 characters.
                    String email = input.getString(sc, "Enter the email of employee: ", "^[A-Za-z0-9]+@([a-z]{2,6}\\\\.[a-z]{2,6}|[a-z]{2,6}\\\\.[a-z]{2,6}\\\\.[a-z]{2,6})*$");
                    EmployeeList.get(index).setEmail(email);
                    break;
                case 6:
                    //[A-Za-z]: must be contains character A-Z and a-z 
                    // \s : matches with space
                    //+: more than one charater or digit , ^: start string, $: end 
                    String address = input.getString(sc, "Enter the address of employee: ", "^[[A-Za-z]\\s]+$");
                    EmployeeList.get(index).setAddress(address);
                    break;
                case 7:
                    Date dob = input.getDate(sc, "Enter the birthday of employee[dd/MM/yyyy]: ");
                    EmployeeList.get(index).setDOB(dob);
                    break;
                case 8:
                    //{FM}{1}: must have only one character 'F' or character 'M'
                    String sex = input.getString(sc, "Enter the gender of employee[F: female; M: male]: ", "[FM]");
                    EmployeeList.get(index).setSex(sex);
                    break;
                case 9:
                    double salary = input.getDouble(sc, "Enter the salary of employee: ", 1, Integer.MAX_VALUE);
                    EmployeeList.get(index).setSalary(salary);
                case 10:
                    //[A-Za-z]: must be contains character A-Z and a-z 
                    // \s : matches with space
                    //+: more than one charater or digit , ^: start string, $: end 
                    String agency = input.getString(sc, "Enter the agency: ", "^[[A-Za-z]\\s]+$");
                    EmployeeList.get(index).setAgency(agency);
                    break;
            }
            display.DisplayList(EmployeeList);
            //[YN]: accept input must be Y or N
            String answer = input.getString(sc, "Do you want to continue updating![Y/N]: ", "[YN]{1}");
            //check answer is equal 'N' or not 
            if (answer.contentEquals("N")) {
                break;
            } else {
                continue;
            }
        } while (true);

    }

    void removeEmployee(ArrayList<Employee> EmployeeList) {
        display.DisplayList(EmployeeList);
        int Id;
        int index;
        //Loop use to check id 
        while (true) {
            Id = input.getInteger(sc, "Enter the ID of employee: ", 1, Integer.MAX_VALUE);
            index = findID(EmployeeList, Id);
            //Check index is exist or not
            if (index == - 1) {
                System.out.println("Can't not find infor employee in list. Plz re-enter!!");
                continue;
            } else {
                break;
            }
        }
        EmployeeList.remove(index);
        display.DisplayList(EmployeeList);
    }

    void searchEmployeeByName(ArrayList<Employee> EmployeeList) {
        int index = -1;
        int count = 0;
        String searchName = input.getString(sc, "Enter the employee's name want to find: ", ".+");
        System.out.println("Result of Search Employee By Name: ");
        System.out.format("%3s%15s%15s%15s%30s%25s%15s%20s%20s%15s\n", "Id", "First Name",
                "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        //loop use to access from first to last list
        for (int i = 0; i < EmployeeList.size(); i++) {
            String FullName = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
            //Check FullName contains input user's name or not
            if (FullName.contains(searchName)) {
                index = i;
                //Compare index with -1
                if (index != -1) {
                    display.DisplayAPartOfList(EmployeeList, index);
                    count++;
                }
            }
        }
        //Check count is equal 0 or not
        if (count == 0) {
            System.out.println("The Employee doesn't exist!!");
        }
    }

    void sortEmployeesBySalary(ArrayList<Employee> EmployeeList) {
        //Loop to show times access of list.
        for (int i = 0; i < EmployeeList.size(); i++) {
            /*Loop use to access from first to stand before the unsorted 
            last element of list*/
            for (int j = 0; j < EmployeeList.size() - i - 1; j++) {
                //Compare two adjecient element 
                if (EmployeeList.get(j).getSalary() > EmployeeList.get(j + 1).getSalary()) {
                    Collections.swap(EmployeeList, j, j + 1);
                }
            }
        }
        display.DisplayList(EmployeeList);
    }

}
