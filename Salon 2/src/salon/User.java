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
import java.util.Scanner;

public class User {
    private String name;
    private String phoneNumber;
    private ArrayList<String> feedbacks;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.feedbacks = new ArrayList<>();
    }

    public void giveFeedback() {
        Scanner input = new Scanner(System.in);
        System.out.println("How was your experience?");
        System.out.println("1- Very Good");
        System.out.println("2- It's Okay");
        System.out.println("3- Not Good");

        String feedback = "";
        String choice = input.nextLine();
        if (choice.equals("1")) {
            feedback = "Very Good";
        } else if (choice.equals("2")) {
            feedback = "It's Okay";
        } else if (choice.equals("3")) {
            System.out.println("What went wrong?");
            feedback = input.nextLine();
        }

        System.out.println("Do you have additional suggestions?");
        feedback += " - " + input.nextLine();
        feedbacks.add(feedback);
        System.out.println("Thank you for your feedback!");
    }

    public ArrayList<String> getFeedbacks() {
        return feedbacks;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void displayRole() {
        System.out.println("Role: User");
    }
}

