/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyPayments;

/**
 *
 * @author alexgopez
 */

public class Cash extends PaymentOption {
    private double discountRate;

    public Cash(double basePrice, double discountRate) {
        super(basePrice); 
        this.discountRate = discountRate; 
    }

    @Override
    public double calculateTCP() {
        double discountAmount = basePrice * discountRate;
        return basePrice - discountAmount;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("Cash Payment (Discount: %.0f%%) - TCP: PHP %.2f", 
                             (discountRate * 100), calculateTCP());
    }
}