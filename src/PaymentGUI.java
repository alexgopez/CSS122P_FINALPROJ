/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyApp;


import MyLib.Transaction;
import MyLib.FinancialAssessment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author jpcrr
 */


public class PaymentGUI extends JFrame {

    JTextField txtBuyer, txtIncome, txtTCP, txtPayment;
    JLabel lblEligibility, lblBalance;

    JButton btnCheck, btnPay;

    Transaction transaction;
    FinancialAssessment assessment;

    int term = 1;

    public PaymentGUI() {

        setTitle("Real Estate Payment System");
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel buyerLabel = new JLabel("Buyer Name:");
        buyerLabel.setBounds(30,30,120,25);
        add(buyerLabel);

        txtBuyer = new JTextField();
        txtBuyer.setBounds(160,30,150,25);
        add(txtBuyer);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setBounds(30,70,120,25);
        add(incomeLabel);

        txtIncome = new JTextField();
        txtIncome.setBounds(160,70,150,25);
        add(txtIncome);

        JLabel tcpLabel = new JLabel("TCP:");
        tcpLabel.setBounds(30,110,120,25);
        add(tcpLabel);

        txtTCP = new JTextField();
        txtTCP.setBounds(160,110,150,25);
        add(txtTCP);

        JLabel paymentLabel = new JLabel("Payment:");
        paymentLabel.setBounds(30,150,120,25);
        add(paymentLabel);

        txtPayment = new JTextField();
        txtPayment.setBounds(160,150,150,25);
        add(txtPayment);

        btnCheck = new JButton("Check Eligibility");
        btnCheck.setBounds(30,200,150,30);
        add(btnCheck);

        btnPay = new JButton("Make Payment");
        btnPay.setBounds(200,200,150,30);
        add(btnPay);

        JLabel eligibilityText = new JLabel("Eligibility:");
        eligibilityText.setBounds(30,250,120,25);
        add(eligibilityText);

        lblEligibility = new JLabel("-");
        lblEligibility.setBounds(160,250,200,25);
        add(lblEligibility);

        JLabel balanceText = new JLabel("Remaining Balance:");
        balanceText.setBounds(30,290,150,25);
        add(balanceText);

        lblBalance = new JLabel("-");
        lblBalance.setBounds(180,290,200,25);
        add(lblBalance);

        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String buyer = txtBuyer.getText();
                double income = Double.parseDouble(txtIncome.getText());
                double tcp = Double.parseDouble(txtTCP.getText());

                assessment = new FinancialAssessment(buyer,income,tcp);

                lblEligibility.setText(assessment.checkEligibility());
            }
        });

        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String buyer = txtBuyer.getText();
                double tcp = Double.parseDouble(txtTCP.getText());
                double payment = Double.parseDouble(txtPayment.getText());

                if(transaction == null){

                    transaction = new Transaction("Today",buyer,payment,tcp,term);

                } else {

                    term++;
                    transaction.addPayment("Today",payment,term);

                }

                lblBalance.setText(String.valueOf(transaction.getRemainingBalance()));
            }
        });

    }
}
