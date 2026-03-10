/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyPayments;

/**
 *
 * @author alexgopez
 */

public abstract class PaymentOption {
    protected double basePrice;

    public PaymentOption(double basePrice) {
        this.basePrice = basePrice;
    }

    public abstract double calculateTCP(); 
    public abstract String getPaymentDetails();
}