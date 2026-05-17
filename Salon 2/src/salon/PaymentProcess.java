/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salon;

/**
 *
 * @author renad
 */
public class PaymentProcess {
    public void processPayment(Payment payment, String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
    case "stc pay":
        processPaymentSTCpay(payment);
        break;
    case "apple pay":
        processPaymentApplepay(payment);
        break;
    case "credit card":
        processPaymentCreditCard(payment);
        break;
    case "cash":
        processPaymentCash(payment);
        break;
    default:
        System.out.println("Invalid payment method: " + paymentMethod);
        break;
}

    }
    public void processPaymentSTCpay(Payment payment) {
        payment.setPaymentMethod("STC Pay");
        System.out.println("Processing STC Pay...");
        payment.setIsPaid(true);
        System.out.println("Payment successful via STC Pay.");
    }
    public void processPaymentApplepay(Payment payment) {
        payment.setPaymentMethod("Apple Pay");
        System.out.println("Processing Apple Pay...");
        payment.setIsPaid(true);
        System.out.println("Payment successful via Apple Pay.");
    }
    public void processPaymentCreditCard(Payment payment) {
        payment.setPaymentMethod("Credit Card");
        System.out.println("Processing Credit Card...");
        payment.setIsPaid(true);
        System.out.println("Payment successful via Credit Card.");
    }
    public void processPaymentCash(Payment payment) {
        payment.setPaymentMethod("Cash");
        System.out.println("Processing Cash Payment...");
        payment.setIsPaid(true);
        System.out.println("Payment successful via Cash.");
    }
}

