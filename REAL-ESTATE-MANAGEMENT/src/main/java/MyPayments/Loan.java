/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyPayments;

/**
 *
 * @author alexgopez
 */
public class Loan extends PaymentOption {
    private double interestRate;
    private int termInYears;

    public Loan(double basePrice, double interestRate, int termInYears) {
        super(basePrice);
        this.interestRate = interestRate;
        this.termInYears = termInYears;
    }

    @Override
    public double calculateTCP() {
        double totalInterest = basePrice * interestRate * termInYears;
        return basePrice + totalInterest;
    }

    public double calculateMonthlyAmortization() {
        int termInMonths = termInYears * 12;
        return calculateTCP() / termInMonths;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("Loan Payment (%d years @ %.0f%% interest) - TCP: PHP %.2f | Monthly: PHP %.2f", 
                             termInYears, (interestRate * 100), calculateTCP(), calculateMonthlyAmortization());
    }
}