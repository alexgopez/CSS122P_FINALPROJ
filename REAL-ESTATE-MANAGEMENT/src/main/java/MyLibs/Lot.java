/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author kiersten
 */
public class Lot {
    private int lotNumber;
    private final double area;
    private double price;
    private String status;
    private Buyer buyer;

    public Lot(int lotNumber, double area, double price){
        this.lotNumber = lotNumber;
        this.area = area;
        this.price = price;
        this.status = "Available";
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void reserveLot(Buyer buyer) {
        if(status.equals("Available")) {
            this.buyer = buyer;
            status = "Reserved";
        }
    }

    public void sellLot(Buyer buyer) {
        if(status.equals("Available") || status.equals("Reserved")) {
            this.buyer = buyer;
            status = "Sold";
        }
    }
}
