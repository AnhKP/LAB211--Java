package doctormanagement;

import java.util.HashMap;
import java.util.Map;

public class Display {

    void DisplayMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("   1. Add Doctor");
        System.out.println("   2. Update Doctor");
        System.out.println("   3. Delete Doctor");
        System.out.println("   4. SearchDoctor");
        System.out.println("   5. Exit");
    }

    void DisplayResult(Doctor doctor) {
        System.out.println("--------- Result ------------");
        System.out.format("%s%30s%30s%30s\n", "Code", "Name", "Specialization", "Availability");
        System.out.format("%s%30s%30s%30s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
    }
    private HashMap<String, Doctor> doctorDB = new HashMap<>();

    public HashMap<String, Doctor> getDoctorDB() {
        return doctorDB;
    }
    void printAllDoctors() {
    System.out.println("-------- Doctor List --------");
    System.out.format("%s%30s%30s%30s\n", "Code", "Name", "Specialization", "Availability");
    for (Doctor doctor : doctorDB.values()) {
        System.out.format("%s%30s%30s%30s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
    }
    }
    void printAllDoctors(HashMap<String, Doctor> doctorDB) {
        System.out.format("%s%30s%30s%30s\n", "Code", "Name", "Specialization", "Availability");
        for (Map.Entry<String, Doctor> entry : doctorDB.entrySet()) {
            Doctor doctor = entry.getValue();
            System.out.format("%s%30s%30s%30s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(),
                    doctor.getAvailability());
        }
    }
}
