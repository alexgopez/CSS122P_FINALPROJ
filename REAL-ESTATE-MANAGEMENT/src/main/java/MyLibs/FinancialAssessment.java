/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author jpcrr
 */
public class FinancialAssessment {

    private String buyer;
    private double income;
    private double tcp;
    private Transaction transaction;

    public FinancialAssessment(String buyer, double income, double tcp) {
        this.buyer = buyer;
        this.income = income;
        this.tcp = tcp;
    }

    public String checkEligibility() {

        if (income >= tcp * 0.20) {
            return "Eligible for Bank Loan";
        }
        else if (income >= tcp * 0.10) {
            return "Eligible for In-House Financing";
        }
        else {
            return "Not Eligible";
        }
    }

    public void linkTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getBuyer() {
        return buyer;
    }
}