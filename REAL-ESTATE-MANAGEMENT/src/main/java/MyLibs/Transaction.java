/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author jpcrr
 */

import MyPayments.PaymentOption; 
import java.util.ArrayList;

public class Transaction {

    private String date;
    private String buyer; 
    private double amountPaid;
    private double tcp;
    private int termNumber;
    private double remainingBalance;
    private ArrayList<String> paymentHistory;
    
    private PaymentOption paymentMethod;

    public Transaction(String date, String buyer, double amountPaid, int termNumber, PaymentOption paymentMethod) {
        this.date = date;
        this.buyer = buyer;
        this.amountPaid = amountPaid;
        this.termNumber = termNumber;
        this.paymentMethod = paymentMethod;
        this.tcp = paymentMethod.calculateTCP();
        this.remainingBalance = this.tcp - amountPaid;
        this.paymentHistory = new ArrayList<>();
        
        this.paymentHistory.add(date + " | Initial Paid: " + amountPaid + " | Term: " + termNumber + " | " + paymentMethod.getPaymentDetails());
    }

    public double computeRemainingBalance() {
        return tcp - amountPaid;
    }

    public void addPayment(String date, double amount, int term) {
        amountPaid += amount;
        termNumber = term;
        remainingBalance = computeRemainingBalance();

        paymentHistory.add(date + " | Paid: " + amount + " | Term: " + term);
    }

//getter
    public double getRemainingBalance() { return remainingBalance; }
    public int getTermNumber() { return termNumber; }
    public ArrayList<String> getPaymentHistory() { return paymentHistory; }
    public String getBuyer() { return buyer; }
    public double getTcp() { return tcp; }
    public PaymentOption getPaymentMethod() { return paymentMethod; }
}