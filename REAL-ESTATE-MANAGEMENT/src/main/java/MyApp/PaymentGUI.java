/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MyApp;

/**
 *
 * @author jpcrr
 */

import MyLibs.Transaction;
import MyLibs.FinancialAssessment;
import MyPayments.PaymentOption;
import MyPayments.Cash;
import MyPayments.Loan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame {

 // TO CHECK AFTER MAKUHA OTHER CLASSES FROM GROUPMATES !

    // Renamed txtTCP to txtBasePrice since the classes calculate the TCP now
    JTextField txtBuyer, txtIncome, txtBasePrice, txtPayment;
    JLabel lblEligibility, lblBalance;
    JComboBox<String> comboPaymentType; // NEW: Dropdown for Cash/Loan
    JButton btnCheck, btnPay;

    
    Transaction transaction;
    FinancialAssessment assessment;

    int term = 1;

    public PaymentGUI() {
        setTitle("Real Estate Payment System");
        setSize(450, 450); 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel buyerLabel = new JLabel("Buyer Name:");
        buyerLabel.setBounds(30, 30, 120, 25);
        add(buyerLabel);

        txtBuyer = new JTextField();
        txtBuyer.setBounds(160, 30, 150, 25);
        add(txtBuyer);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setBounds(30, 70, 120, 25);
        add(incomeLabel);

        txtIncome = new JTextField();
        txtIncome.setBounds(160, 70, 150, 25);
        add(txtIncome);

        JLabel basePriceLabel = new JLabel("Base Price:");
        basePriceLabel.setBounds(30, 110, 120, 25);
        add(basePriceLabel);

        txtBasePrice = new JTextField();
        txtBasePrice.setBounds(160, 110, 150, 25);
        add(txtBasePrice);

        // NEW CHANGES:  Payment Type Selection
        JLabel typeLabel = new JLabel("Payment Type:");
        typeLabel.setBounds(30, 150, 120, 25);
        add(typeLabel);

        String[] types = {"Cash (5% Discount)", "Loan (10% Interest, 5 Yrs)"};
        comboPaymentType = new JComboBox<>(types);
        comboPaymentType.setBounds(160, 150, 200, 25);
        add(comboPaymentType);

        JLabel paymentLabel = new JLabel("Initial Payment:");
        paymentLabel.setBounds(30, 190, 120, 25);
        add(paymentLabel);

        txtPayment = new JTextField();
        txtPayment.setBounds(160, 190, 150, 25);
        add(txtPayment);

        btnCheck = new JButton("Check Eligibility");
        btnCheck.setBounds(30, 240, 150, 30);
        add(btnCheck);

        btnPay = new JButton("Make Payment");
        btnPay.setBounds(200, 240, 150, 30);
        add(btnPay);

        JLabel eligibilityText = new JLabel("Eligibility:");
        eligibilityText.setBounds(30, 290, 120, 25);
        add(eligibilityText);

        lblEligibility = new JLabel("-");
        lblEligibility.setBounds(160, 290, 250, 25);
        add(lblEligibility);

        JLabel balanceText = new JLabel("Remaining Balance:");
        balanceText.setBounds(30, 330, 150, 25);
        add(balanceText);

        lblBalance = new JLabel("-");
        lblBalance.setBounds(180, 330, 200, 25);
        add(lblBalance);


        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String buyer = txtBuyer.getText();
                    double income = Double.parseDouble(txtIncome.getText());
                    double basePrice = Double.parseDouble(txtBasePrice.getText());

                    // Assuming FinancialAssessment still takes TCP, we can calculate a rough TCP here
                    // or update FinancialAssessment to take basePrice. For now, we pass basePrice.
                    assessment = new FinancialAssessment(buyer, income, basePrice);
                    lblEligibility.setText(assessment.checkEligibility());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for Income and Base Price.");
                }
            }
        });
   
    //I GOT THIS FROM GEMINI WAIT LANG CCHECK KO RIN TO PAG KUMPLETO NA CLASSES
        
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String buyer = txtBuyer.getText();
                    double basePrice = Double.parseDouble(txtBasePrice.getText());
                    double payment = Double.parseDouble(txtPayment.getText());
                    
                    // Determine which payment method was selected from the dropdown
                    PaymentOption selectedPaymentMethod;
                    int selectedIndex = comboPaymentType.getSelectedIndex();
                    
                    if (selectedIndex == 0) { // Cash selected
                        selectedPaymentMethod = new Cash(basePrice, 0.05); // 5% discount
                    } else { // Loan selected
                        selectedPaymentMethod = new Loan(basePrice, 0.10, 5); // 10% interest, 5 years
                    }

                    if (transaction == null) {
                        // Using the new constructor that accepts a PaymentOption
                        // We use a dummy date for now, but you can add a Date field later!
                        transaction = new Transaction("2026-03-10", buyer, payment, term, selectedPaymentMethod);
                        
                        // Show a success message displaying the dynamically calculated TCP
                        JOptionPane.showMessageDialog(null, "Transaction created!\n" + selectedPaymentMethod.getPaymentDetails());
                    } else {
                        term++;
                        transaction.addPayment("2026-03-10", payment, term);
                    }

                    lblBalance.setText("PHP " + String.format("%.2f", transaction.getRemainingBalance()));
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for Price and Payment.");
                }
            }
        });
    }
}