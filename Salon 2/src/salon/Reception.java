/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salon;

/**
 *
 * @author renad
 */
import java.util.ArrayList;

public class Reception extends User {

    public Reception(String name, String phoneNumber) {
        super(name, phoneNumber);
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Receptionist");
    }
    
    public void displayReceptionistRole() {
        displayRole();
    }
}
