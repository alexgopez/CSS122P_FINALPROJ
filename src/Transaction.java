/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

/**
 *
 * @author jpcrr
 */
import java.util.ArrayList;

public class Transaction {

    private String date;
    private String buyer;
    private double amountPaid;
    private double tcp;
    private int termNumber;
    private double remainingBalance;
    private ArrayList<String> paymentHistory;

    public Transaction(String date, String buyer, double amountPaid, double tcp, int termNumber) {
        this.date = date;
        this.buyer = buyer;
        this.amountPaid = amountPaid;
        this.tcp = tcp;
        this.termNumber = termNumber;

        remainingBalance = tcp - amountPaid;

        paymentHistory = new ArrayList<>();
        paymentHistory.add(date + " | Paid: " + amountPaid + " | Term: " + termNumber);
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

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public int getTermNumber() {
        return termNumber;
    }

    public ArrayList<String> getPaymentHistory() {
        return paymentHistory;
    }

    public String getBuyer() {
        return buyer;
    }
}
