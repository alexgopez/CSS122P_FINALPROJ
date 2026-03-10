/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author kiersten
 */
public class Block {
    private int blockNumber;
    private Lot[] lots;

    public Block(int blockNumber) {
        this.blockNumber = blockNumber;
        lots = new Lot[20]; // To create 20 lots in each block

        for(int i = 0; i < 20; i++) {
            double area = 100 + (i * 5);
            double price = 500000 + (i * 10000);

            lots[i] = new Lot(i + 1, area, price);
        }
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public Lot[] getLots() {
        return lots;
    }

    public void displayLots() {
        for (Lot lot : lots) {
            System.out.println (
                "Block " + blockNumber + " | Lot " + lot.getLotNumber() + " | Area " + lot.getArea() +
                " | Price " + lot.getPrice() + " | Status " + lot.getStatus()
            );
        }
    }
}
