import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String phone;
    private String availability;

    public Doctor(int id, String name, String specialization, String phone, String availability) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.availability = availability;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getPhone() { return phone; }
    public String getAvailability() { return availability; }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Specialization: " + specialization +
               ", Phone: " + phone + ", Availability: " + availability;
    }
}

class Patient {
    private int id;
    private String name;
    private String phone;
    private String address;

    public Patient(int id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phone + ", Address: " + address;
    }
}

class Appointment {
    private int patientId;
    private int doctorId;
    private String date;
    private String timeSlot;
    private String clinicName;

    public Appointment(int patientId, int doctorId, String date, String timeSlot, String clinicName) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.timeSlot = timeSlot;
        this.clinicName = clinicName;
    }

    public String toString() {
        return "Patient ID: " + patientId + ", Doctor ID: " + doctorId + ", Date: " + date +
               ", Time Slot: " + timeSlot + ", Clinic: " + clinicName;
    }
}

public class DrAppoinmentManagement {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        addInitialData();

        while (true) {
            System.out.println("\nSimple Appointment System");
            System.out.println("1. Register Patient  2. Register Doctor  3. View Doctors");
            System.out.println("4. Book Appointment  5. View Appointments  6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    registerDoctor();
                    break;
                case 3:
                    viewDoctors();
                    break;
                case 4:
                    bookAppointment();
                    break;
                case 5:
                    viewAppointments();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addInitialData() {
        // Add Patient
        Patient patient = new Patient(10051, "Jannatul Tazree", "01300630190", "Tangail");
        patients.add(patient);

        Patient patient1 = new Patient(10052, "Asma Sadia Sumaiya", "01983454541", "Noakhali");
        patients.add(patient1);

        Patient patient2 = new Patient(10053, "Alrazi Arman", "015784565456", "Lakshmipur");
        patients.add(patient2);

        Patient patient3 = new Patient(10054, "Hurain Akther", "01745773412", "Dhaka");
        patients.add(patient3);

        // Add Doctors
        Doctor doctor1 = new Doctor(201153279, "Imran Hossain Ayan", "General Medicine", "01999322645", "9 AM - 5 PM");
        doctors.add(doctor1);
    
        Doctor doctor2 = new Doctor(201153179, "Md Asraful Sharker Nirob", "Neurology", "0161674552", "10 AM - 4 PM");
        doctors.add(doctor2);
    
        Doctor doctor3 = new Doctor(20115344, "Jannatul Noumi", "Dermatology", "0171728974", "4 PM - 9 PM");
        doctors.add(doctor3);
    
        Doctor doctor4 = new Doctor(201153779, "Sajib Bin Mamun", "Pediatrics", "016541552", "9 AM - 4 PM");
        doctors.add(doctor4);
    
        
        Appointment appointment = new Appointment(10054, 201153279, "2024-09-12", "10 AM", "Ibn Sina Medical Hospital");
        appointments.add(appointment);
    }
    

    private static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        patients.add(new Patient(id, name, phone, address));
        System.out.println("Patient registered successfully.");
    }

    private static void registerDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Availability: ");
        String availability = scanner.nextLine();
        doctors.add(new Doctor(id, name, specialization, phone, availability));
        System.out.println("Doctor registered successfully.");
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered yet.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }
    
    private static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Time Slot: ");
        String timeSlot = scanner.nextLine();
        System.out.print("Enter Clinic Name: ");
        String clinicName = scanner.nextLine();
        appointments.add(new Appointment(patientId, doctorId, date, timeSlot, clinicName));
        System.out.println("Appointment booked successfully.");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked yet.");
        } else {
            System.out.println("List of Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}
