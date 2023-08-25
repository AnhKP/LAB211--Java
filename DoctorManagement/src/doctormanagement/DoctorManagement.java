package doctormanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoctorManagement{

    getInput input = new getInput();
    Display display = new Display();
    Scanner sc = new Scanner(System.in);
    public boolean checkDuplicateCode(String Code, ArrayList<Doctor> DoctorList) {
        boolean isExist = false;
        if (DoctorList.isEmpty()) {
            return isExist;
        } else {
            //Loop use to access from first to last list
            for (int i = 0; i < DoctorList.size(); i++) {
                //Compare ID from input and each ID of employee has in EmployeeList
                if ( Code == DoctorList.get(i).getCode()) {
                    System.out.println("ID existed!!");
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }
   
    public void addDoctor(ArrayList<Doctor> DoctorList) {
        //A-Z: character from A to Z
        //0 - 9: digit from 0 to 9
        //^: start
        //+: must be more than one
         String code;
        //Check List is empty or not 
        if (DoctorList.isEmpty()) {
            System.out.println("List doesn't exist");
        } else {
            DisplayList(DoctorList);
        }
        //Loop use to check ID 
        while (true) {
            code = input.getString(sc, "Enter Code: ", "^[COD]{3}\\s[0-9]+$");
            boolean isExist = checkDuplicateCode(code,DoctorList);
            //check isExit
            if (isExist == true) {
                continue;
            } else {
                break;
            }
        }
        String name = input.getString(sc, "Enter Name: ", "^[A-Za-z]+$");
        String specialiazation = input.getString(sc, "Enter Specialization: ", "^[A-Za-z]+$");
        int availability = input.getInputChoice(sc, "Enter Availability:", 0, Integer.MAX_VALUE);
        Doctor doctor = new Doctor(code, name, specialiazation, availability);
        DoctorList.add(doctor);
        System.out.println("Add infor successfully!!");
    }
    public void updateDoctor(ArrayList<Doctor> DoctorList, String code){
        //Check List is empty or not 
        if (DoctorList.isEmpty()) {
            System.out.println("List doesn't exist");
        } else {
            DisplayList(DoctorList);
        }  
        //Loop use to check ID 
        while (true) {
            code = input.getString(sc, "Enter Code: ", "^[COD]{3}\\s[0-9]+$");
            boolean isExist = checkDuplicateCode(code,DoctorList);
            //check isExit
            if (isExist == true) {
                continue;
            } else {
                break;
            }
        }
        
        
        System.out.println("Update infor succeesfully");
    }
//public int updateDoctor(ArrayList<Doctor> DoctorList, int id){
//   int index = -1;
//        //Check list is empty or not 
//        if (DoctorList.isEmpty()) {
//            System.out.println("List is empty!!!");
//        } else {
//            //loop use to access from first to last list
//            for (int i = 0; i <DoctorList.size(); i++) {
//                //Compare id input and each id of employee has in list
//                if (id == DoctorList.get(i).getId()) {
//                    index = DoctorList.indexOf(EmployeeList.get(i));
//                    break;
//                }
//            }
//        }
//        return index;
//    }
//    while(true) {
//        System.out.println("Choose update option:");
//        System.out.println("1. Update Name: ");
//        System.out.println("2. Update Specialization: ");
//        System.out.println("3. Update Availability: ");
//        int choice = input.getInputChoice(sc, "Enter your choice: ", 1, 3);
//        switch (choice) {
//            case 1:
//                String name = input.getString(sc, "Enter Name: ", "^[A-Za-z]+$");
//                doctor.setName(name);
//                break;
//            case 2:
//                String specialiazation = input.getString(sc, "Enter Specialization: ", "^[A-Za-z]+$");
//                doctor.setSpecialization(specialiazation);   
//                break;
//            case 3:
//                int availability = input.getInputChoice(sc, "Enter Availability:", 0, Integer.MAX_VALUE);
//                doctor.setAvailability(availability);
//                break;
//        }
//        System.out.println("Update successfully");
//        display.DisplayResult(doctor);
//        String answer = input.getString(sc, "Do you want to continue?y|n: ", "[yn]");
//        if (answer.equals("n")) {
//            break;
//        } else {
//            continue;
//        }
//    }
//    return true;
//}
//    public boolean updateDoctor(Doctor doctor) throws Exception {
//        //A-Z: character from A to Z
//        //0 - 9: digit from 0 to 9
//        //^: start
//        //+: must be more than one
//        while (true) {
//            String code = input.getString(sc, "Enter Code: ", "^[COD]{3}[0-9]+$");
//            if (!doctorDB.containsKey(code)) {
//                System.out.println("Doctor code[" + code + "] not found!!");
//                continue;
//            } else {
//                doctor.getCode();
//                break;
//            }
//        }
//        //Loop use to 
//        while (true) {
//            System.out.println("Choose update option:");
//            System.out.println("1. Update Code");
//            System.out.println("2. Update Name: ");
//            System.out.println("3. Update Specialization: ");
//            System.out.println("4. Update Availability: ");
//            int choice = input.getInputChoice(sc, "Enter your choice: ", 1, 4);
//            switch (choice) {
//                case 1:
//                    while (true) {
//                        String code = input.getString(sc, "Enter Code: ", "^[COD]{3}[0-9]+$");
//                        if (doctorDB.containsKey(code)) {
//                            System.out.println("Doctor code[" + code + "] is duplicate");
//                            continue;
//                        } else {
//                            doctor.setCode(code);
//                            break;
//                        }
//                    }
//                    doctorDB.put(doctor.getCode(), doctor);
//                    break;
//                case 2:
//                    String name = input.getString(sc, "Enter Name: ", "^[A-Za-z]+$");
//                    doctor.setName(name);
//                    doctorDB.put(doctor.getName(), doctor);
//                    break;
//                case 3:
//                    String specialiazation = input.getString(sc, "Enter Specialization: ", "^[A-Za-z]+$");
//                    doctor.setSpecialization(specialiazation);
//                    break;
//                case 4:
//                    int availability = input.getInputChoice(sc, "Enter Availability:", 0, Integer.MAX_VALUE);
//                    doctor.setAvailability(availability);
//                    break;
//            }
//            System.out.println("Update successfully");
//            String answer = input.getString(sc, "Do you want to continue?y|n: ", "[yn]");
//            //compare value of answer with string "n"
//            if (answer.equals("n")) {
//                break;
//            } else {
//                continue;
//            }
//        }
//        return true;
//    }

//    public boolean deleteDoctor(Doctor doctor) throws Exception {
//        String code = input.getString(sc, "Enter Code: ", "^[COD]{3}[0-9]+$");
//        if (doctorDB.containsKey(code)) {
//            doctorDB.remove(code);
//            System.out.println("Doctor with code[" + code + "] deleted successfully.");
//            return true;
//        } else {
//            System.out.println("Doctor code[" + code + "] not found.");
//            return false;
//        }
//    }
//
//    public HashMap<String, Doctor> searchDoctor(String input) {
//       HashMap<String, Doctor> searchResult = new HashMap<>();
//        for (Map.Entry<String, Doctor> entry : doctorDB.entrySet()) {
//            Doctor doctor = entry.getValue();
//            if (doctor.getName().toLowerCase().contains(input.toLowerCase())) {
//                searchResult.put(entry.getKey(), doctor);
//            }
//        }
//        return searchResult;
//    }
    void DisplayAPartOfList(ArrayList<Doctor> DoctorList, int index) {
        System.out.println("--------- Result ------------");
        System.out.format("%3d%10s%10s%15s%30s%20s%12s%5s%10d%10s\n",
                DoctorList.get(index).getCode(), DoctorList.get(index).getName(),
                DoctorList.get(index).getSpecialization(), DoctorList.get(index).getAvailability());
    }

    void DisplayList(ArrayList<Doctor> DoctorList) {
        System.out.println("--------- Result ------------");
        System.out.format("%3s%15s%30s%20s\n", "Code", "Name","Specialization", "Availability");
        //loop use to access each element of arraylist from begining to the end
        for (int i = 0; i < DoctorList.size(); i++) {
            DisplayAPartOfList(DoctorList, i);
        }
    }
}
