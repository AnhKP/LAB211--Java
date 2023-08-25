
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class Display{
    void DisplayMenu(){
            System.out.println("Main menu:");
            System.out.println("\t1. Add employees");
            System.out.println("\t2. Update employees");
            System.out.println("\t3. Remove employees");
            System.out.println("\t4. Search employees");
            System.out.println("\t5. Sort employees by salary");
            System.out.println("\t6. Exit");
    }
     void DisplayAPartOfList(ArrayList<Employee> EmployeeList, int index) {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String dateOfBirth = date.format(EmployeeList.get(index).getDOB());
        System.out.format("%3s%15s%15s%15s%30s%25s%15s%20s%20s%15s\n",
                EmployeeList.get(index).getId(), EmployeeList.get(index).getFirstName(),
                EmployeeList.get(index).getLastName(),
                EmployeeList.get(index).getPhone(), EmployeeList.get(index).getEmail(),
                EmployeeList.get(index).getAddress(),
                date.format(EmployeeList.get(index).getDOB()), 
                EmployeeList.get(index).getSex(),
                EmployeeList.get(index).getSalary(), 
                EmployeeList.get(index).getAgency());
    }

    void DisplayList(ArrayList<Employee> EmployeeList) {
        System.out.println("The Employees List: ");
        System.out.format("%3s%15s%15s%15s%30s%25s%15s%20s%20s%15s\n", "Id", "First Name",
                "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        //loop use to access each element of arraylist from begining to the end
        for (int i = 0; i < EmployeeList.size(); i++) {
            DisplayAPartOfList(EmployeeList, i);
        }
    }
}

