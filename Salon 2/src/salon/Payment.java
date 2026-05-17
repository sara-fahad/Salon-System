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
import java.util.Date;

public class Payment {
    private String paymentMethod;
    private double discount;
    private double totalAmount;
    private boolean isPaid;
    private final Date invoiceDate;
    private String customerName;
    private String phoneNumber;
    private String appointmentID;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Payment() {
        this.invoiceDate = new Date();
        this.isPaid = false;
        this.totalAmount = 0.0;
    }

    public void setPaymentMethod(String method) {
        this.paymentMethod = method;
    }

    public boolean checkPaymentStatus() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setAppointmentDate(LocalDate date) {
        this.appointmentDate = date;
    }

    public void setAppointmentTime(LocalTime time) {
        this.appointmentTime = time;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }
    public void setTotalAmount(double amount) {
    this.totalAmount = amount;
}

public double calculateDiscount(boolean isFirstTimeCustomer) {
    if (isFirstTimeCustomer) {
        discount = totalAmount * 0.10;
    } else {
        discount = 0.00;
    }
    return totalAmount - discount;
}

public void printInvoice() {
    System.out.println("----------- INVOICE -----------");
    System.out.println("Appointment ID: " + appointmentID);
    System.out.println("Customer Name: " + customerName);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Invoice Date: " + invoiceDate);
    System.out.println("Appointment Date & Time: " + appointmentDate + " " + appointmentTime);
    System.out.println("Total Amount: $" + totalAmount);
    System.out.println("Discount: -$" + discount);
    System.out.println("Amount Paid: $" + (totalAmount - discount));
    System.out.println("Payment Method: Pending");
    System.out.println("Payment Status: " + (isPaid ? "Paid" : "Not Paid"));
    System.out.println("-------------------------------");
}

}
