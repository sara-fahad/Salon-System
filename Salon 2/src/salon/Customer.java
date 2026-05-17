/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salon;

/**
 *
 * @author renad
 */
public class Customer extends User {
    private boolean isFirstTimeCustomer;

    public Customer(String name, String phoneNumber, boolean isFirstTimeCustomer) {
        super(name, phoneNumber);
        this.isFirstTimeCustomer = isFirstTimeCustomer;
    }

    public boolean isFirstTimeCustomer() {
        return isFirstTimeCustomer;
    }

    public void setFirstTimeCustomer(boolean firstTimeCustomer) {
        isFirstTimeCustomer = firstTimeCustomer;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }

    public void displayCustomerDetails() {
        System.out.println("Customer Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("First-Time Customer: " + (isFirstTimeCustomer ? "Yes" : "No"));
    }
}
