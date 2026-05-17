/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salon;

/**
 *
 * @author renad
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Appointment {
    private String appointmentID;
    private LocalDate date;
    private LocalTime time;
    private ArrayList<Service> services;
    private String customerName;
    private String phoneNumber;
    private String status;

    public Appointment(String appointmentID, LocalDate date, LocalTime time, ArrayList<Service> services, String customerName, String phoneNumber, String status) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.services = services;
        this.customerName = customerName;
        this.phoneNumber=phoneNumber;
        this.status = status;
    }

    public void viewAppointmentDetails() {
        System.out.println("\nAppointment Details:");
        System.out.println("ID: " + appointmentID);
        System.out.println("Customer: " + customerName);
        System.out.println("Phone Number: "+ phoneNumber);
        System.out.print("Services: ");
        for (Service service : services) {
            System.out.print(service.getName() + ", ");
        }
        System.out.println("\nDate: " + date);
        System.out.println("Time: " + time);
        System.out.println("Status: " + status);
    }

    public void updateAppointment(Service newService, LocalDate newDate, LocalTime newTime) {
        this.services.add(newService);
        this.date = newDate;
        this.time = newTime;
        this.status = "Updated";
    }
    
    public void cancelAppointment() {
        this.status = "Cancelled";
    }

    public String getAppointmentID() {
        return appointmentID;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (Service service : services) {
            total += service.getPrice();
        }
        return total;
    }

    public LocalDate getAppointmentDate() {
        return date;
    }
    
    public LocalTime getAppointmentTime() {
        return time;
    }
    public ArrayList<Service> getServices() {
        return services;
    }
}



