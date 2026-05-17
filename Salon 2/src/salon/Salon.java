/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salon;

/**
 *
 * @author renad
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Salon {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Service> services = new ArrayList<>();
        services.add(new HairService("Haircut", "A basic haircut", 30.00));
        services.add(new HairService("Hair Coloring", "Color your hair with a new shade", 50.00));
        services.add(new HairService("Highlights", "Add highlights to your hair", 70.00));
        services.add(new HairService("Keratin Treatment", "Smooth your hair with keratin", 100.00));
        services.add(new SkinCareService("Deep Facial Cleansing", "Cleanse and refresh your skin", 60.00));
        services.add(new NailCareService("Manicure", "Basic manicure service", 25.00));
        services.add(new BodyCareService("Relaxing Massage", "A full body relaxation massage", 80.00));
        services.add(new MakeupService("Evening Makeup", "Makeup for evening events", 45.00));
        services.add(new HairstyleService("Simple Hairstyle", "Quick and easy hairstyle", 20.00));

        ArrayList<Appointment> appointments = new ArrayList<>();
        Reception receptionist = new Reception("Receptionist", "000-000-0000");
        PaymentProcess paymentProcess = new PaymentProcess();

        boolean exitSystem = false;
        System.out.println("\nWelcome to Beauty Salon!");

        while (!exitSystem) {
            System.out.println("\nBeauty Salon Menu");
            System.out.println("1. Customer Menu");
            System.out.println("2. Receptionist Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    boolean exitCustomerMenu = false;
                    while (!exitCustomerMenu) {
                        System.out.println("\nCustomer Menu");
                        System.out.println("1. View Services");
                        System.out.println("2. Create Appointment");
                        System.out.println("3. View Appointment");
                        System.out.println("4. Make Payment");
                        System.out.println("5. Give Feedback");
                        System.out.println("6. Exit");
                        System.out.print("Choose an option: ");
                        int customerChoice = input.nextInt();
                        input.nextLine();

                        switch (customerChoice) {
                            case 1:
                                System.out.println("\nAvailable Services:");
                                for (int i = 0; i < services.size(); i++) {
                                    System.out.println((i + 1) + ". " + services.get(i).toString());
                                }
                                break;
                            case 2:
                                System.out.print("Enter your name: ");
                                String customerName = input.nextLine();
                                String phoneNumber;
                                while (true) {
                                    System.out.print("Enter your phone number: ");
                                    phoneNumber = input.nextLine();
                                    if (phoneNumber.matches("05\\d{8}")) {
                                        break;
                                    }
                                    System.out.println("Invalid phone number. Please ensure it is 10 digits and starts with '05'.");
                                }
                                ArrayList<Service> selectedServices = new ArrayList<>();
                                double totalAmount = 0.0;
                                boolean addMoreServices = true;
                                while (addMoreServices) {
                                    System.out.println("\nAvailable Services:");
                                    for (int i = 0; i < services.size(); i++) {
                                        System.out.println((i + 1) + ". " + services.get(i).toString());
                                    }
                                    System.out.print("Select a service by number: ");
                                    int serviceChoice = input.nextInt();
                                    input.nextLine();
                                    if (serviceChoice < 1 || serviceChoice > 9) {
                                        System.out.println("Invalid input. Please choose a number between 1 and 9.");
                                    } else {
                                    selectedServices.add(services.get(serviceChoice - 1));
                                    totalAmount+=services.get(serviceChoice - 1).getPrice();
                                    String userChoice = "";
                                    while (!userChoice.equalsIgnoreCase("yes") && !userChoice.equalsIgnoreCase("no")) {
                                        System.out.print("Would you like to add another service? (yes/no): ");
                                        userChoice = input.nextLine();
                                        if (userChoice.equalsIgnoreCase("no")) {
                                            addMoreServices = false;
                                        } else if (!userChoice.equalsIgnoreCase("yes")) {
                                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                        }
                                    }
                                    }
                                }
                                System.out.println("\nYou have selected the following services:");
                                for (Service service : selectedServices) {
                                    System.out.println(service.toString());
                                }
                                System.out.println("Total amount: $" + totalAmount);
                                String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
                                String timeRegex = "^\\d{2}:\\d{2}$";
                                System.out.print("Enter the date for the appointment (yyyy-mm-dd): ");
                                String dateInput = input.nextLine();
                                while (!dateInput.matches(dateRegex)) {
                                    System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd.");
                                    dateInput = input.nextLine();
                                    System.out.println(" ");
                                }
                                LocalDate date = LocalDate.parse(dateInput);
                                System.out.print("Enter the time for the appointment (HH:mm): ");
                                String timeInput = input.nextLine();
                                while (!timeInput.matches(timeRegex)) {
                                    System.out.println("Invalid time format. Please enter the time in the format HH:mm.");
                                    timeInput = input.nextLine();
                                    System.out.println(" ");
                                }
                                LocalTime time = LocalTime.parse(timeInput);
                                
                                String appointmentID = "A" + (appointments.size() + 1);
                                Appointment newAppointment = new Appointment(appointmentID, date, time, selectedServices, customerName, phoneNumber, "Scheduled");
                                appointments.add(newAppointment);
                                System.out.println("Appointment created successfully with ID: " + appointmentID);
                                break;
                            case 3:
                                System.out.print("Enter your Appointment ID: ");
                                String appointmentIDView = input.nextLine();
                                Appointment foundAppointment = null;

                                while (foundAppointment == null) {
                                    for (Appointment appointment : appointments) {
                                        if (appointment.getAppointmentID().equals(appointmentIDView)) {
                                            foundAppointment = appointment;
                                            break;
                                        }
                                    }
                                    if (foundAppointment != null) {
                                        foundAppointment.viewAppointmentDetails();
                                        break;
                                    } else {
                                        System.out.println("Appointment not found. Please enter a valid Appointment ID.");
                                        System.out.print("Enter your Appointment ID: ");
                                        appointmentIDView = input.nextLine();
                                    }
                                }
                                break;

                            case 4:
                                System.out.print("Enter your Appointment ID to make payment: ");
                                String appointmentIDPayment = input.nextLine();
                                Appointment foundPaymentAppointment = null;

                                while (foundPaymentAppointment == null) {
                                    for (Appointment appointment : appointments) {
                                        if (appointment.getAppointmentID().equals(appointmentIDPayment)) {
                                            foundPaymentAppointment = appointment;
                                            break;
                                        }
                                    }
                                    if (foundPaymentAppointment != null) {
                                        Payment payment = new Payment();
                                        payment.setCustomerName(foundPaymentAppointment.getCustomerName());
                                        payment.setPhoneNumber(foundPaymentAppointment.getPhoneNumber());
                                        double totalAmountPayment = 0;
                                        for (Service service : foundPaymentAppointment.getServices()) {
                                            totalAmountPayment += service.getPrice();
                                        }
                                        payment.setTotalAmount(totalAmountPayment);
                                        System.out.println("Total amount for the selected services: $" + totalAmountPayment);
                                        System.out.print("Is this your first visit? (yes/no): ");
                                        String userChoice = input.nextLine();
                                        while (!userChoice.equalsIgnoreCase("yes") && !userChoice.equalsIgnoreCase("no")) {
                                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                            System.out.print("Is this your first visit? (yes/no): ");
                                            userChoice = input.nextLine();
                                        }
                                    boolean isFirstTimeCustomer = userChoice.equalsIgnoreCase("yes");
                                    payment.calculateDiscount(isFirstTimeCustomer);
                                    payment.setAppointmentID(appointmentIDPayment);
                                    payment.setAppointmentDate(foundPaymentAppointment.getAppointmentDate());
                                    payment.setAppointmentTime(foundPaymentAppointment.getAppointmentTime());
                                    payment.setIsPaid(true);
                                    boolean validPaymentMethod = false;
                                    while (!validPaymentMethod) {
                                        System.out.print("Choose payment method (stc pay, apple pay, credit card, cash): ");
                                        String paymentMethod = input.nextLine().toLowerCase();
                                        if (paymentMethod.equals("stc pay") || paymentMethod.equals("apple pay") || paymentMethod.equals("credit card") || paymentMethod.equals("cash")) {
                                            payment.setPaymentMethod(paymentMethod);
                                            payment.printInvoice();
                                            paymentProcess.processPayment(payment, paymentMethod);
                                            System.out.println("Payment Status: Successful");
                                            validPaymentMethod = true;
                                        } else {
                                            System.out.println("Invalid payment method. Please choose from: stc pay, apple pay, credit card, or cash.");
                                            }
                                        }
                                    break;
                                    } else {
                                        System.out.println("Appointment not found. Please enter a valid Appointment ID.");
                                        System.out.print("Enter your Appointment ID to make payment: ");
                                        appointmentIDPayment = input.nextLine();
                                    }
                                }
                                break;

                            case 5:
                                System.out.print("Enter your name: ");
                                String userName = input.nextLine();
                                System.out.print("Enter your phone number: ");
                                String userPhone = input.nextLine();
                                User user = new User(userName, userPhone);
                                user.giveFeedback();
                                break;

                            case 6:
                                exitCustomerMenu = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;

                case 2:
                
                    boolean exitReceptionMenu = false;
                    while (!exitReceptionMenu) {
                        System.out.println("\nReceptionist Menu:");
                        System.out.println("1. View All Appointments");
                        System.out.println("2. Delete an Appointment");
                        System.out.println("3. Update an Appointment");
                        System.out.println("4. Exit");
                        System.out.print("Choose an option: ");
                        int receptionistChoice = input.nextInt();
                        input.nextLine();

                        switch (receptionistChoice) {
                            case 1:
                                System.out.println("\nAll Appointments:");
                                if (appointments.isEmpty()) {
                                    System.out.println("No appointments found.");
                                } else {
                                    for (Appointment appointment : appointments) {
                                        appointment.viewAppointmentDetails();
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("\nEnter Appointment ID to delete: ");
                                String appointmentIDDelete = input.nextLine();
                                Appointment appointmentToDelete = null;
                                for (Appointment appointment : appointments) {
                                    if (appointment.getAppointmentID().equals(appointmentIDDelete)) {
                                        appointmentToDelete = appointment;
                                        break;
                                    }
                                }
                                if (appointmentToDelete != null) {
                                    appointments.remove(appointmentToDelete);
                                    System.out.println("Appointment deleted successfully!");
                                } else {
                                    System.out.println("Appointment not found.");
                                }
                                break;
                            case 3:
                                System.out.print("\nEnter Appointment ID to update: ");
                                String appointmentIDUpdate = input.nextLine();
                                Appointment appointmentToUpdate = null;
                                for (Appointment appointment : appointments) {
                                    if (appointment.getAppointmentID().equals(appointmentIDUpdate)) {
                                        appointmentToUpdate = appointment;
                                        break;
                                    }
                                }
                                if (appointmentToUpdate != null) {
                                    System.out.println("\nExisting Appointment Details:");
                                    appointmentToUpdate.viewAppointmentDetails();
                                    System.out.print("\nDo you want to add a new service to this appointment? (yes/no): ");
                                    String addNewService = input.nextLine();

                                    if (addNewService.equalsIgnoreCase("yes")) {
                                        System.out.println("\nAvailable Services:");
                                        for (int i = 0; i < services.size(); i++) {
                                            System.out.println((i + 1) + ". " + services.get(i).toString());
                                        }
                                    System.out.print("\nEnter the number of the service to add: ");
                                    int serviceChoice = input.nextInt();
                                    input.nextLine();
                                    if (serviceChoice >= 1 && serviceChoice <= services.size()) {
                                        Service selectedService = services.get(serviceChoice - 1);
                                        System.out.println("Service added: " + selectedService.getName());
                                        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
                                        System.out.print("Enter the new date for the appointment (yyyy-mm-dd): ");
                                        String newDateInput = input.nextLine();
                                        while (!newDateInput.matches(dateRegex)) {
                                            System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd.");
                                            newDateInput = input.nextLine();
                                        }
                                    LocalDate newDate = LocalDate.parse(newDateInput);
                                    String timeRegex = "^\\d{2}:\\d{2}$";
                                    System.out.print("Enter the new time for the appointment (HH:mm): ");
                                    String newTimeInput = input.nextLine();
                                    while (!newTimeInput.matches(timeRegex)) {
                                        System.out.println("Invalid time format. Please enter the time in the format HH:mm.");
                                        newTimeInput = input.nextLine();
                                    }
                                    LocalTime newTime = LocalTime.parse(newTimeInput);
                                    appointmentToUpdate.updateAppointment(selectedService, newDate, newTime);
                                    System.out.println("Appointment updated successfully!");
                                    appointmentToUpdate.viewAppointmentDetails();
                                    } else {
                                        System.out.println("Invalid service choice.");
                                    }
                                    } else {
                                        System.out.println("No new service added.");
                                    }
                                    } else {
                                        System.out.println("Appointment not found.");
                                    }
                                break;
                            case 4:
                                exitReceptionMenu = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;

                case 3:
                    exitSystem = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

