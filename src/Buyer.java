import java.util.List;

public class Buyer {
    private String buyer;
    private String profession;
    private String dateAcquired;
    private String paymentStatus;
    private int lotNumber;
    private int blockNumber;
    private double tcp;
    private double totalAmount;
    private double remainingBalance;

    public Buyer(String buyer, String profession, String dateAcquired,
                 int lotNumber, int blockNumber, double tcp) {
        this.buyer = buyer;
        this.profession = profession;
        this.dateAcquired = dateAcquired;
        this.lotNumber = lotNumber;
        this.blockNumber = blockNumber;
        this.tcp = tcp;
        this.totalAmount = 0;
        this.remainingBalance = tcp;
        updatePaymentStatus();
    }

    public void updatePayments(List<Transaction> transactions) {
        totalAmount = 0;
        for (Transaction t : transactions) {
            if (t.getBuyer().equals(this)) {  
                totalAmount += t.getAmountPaid();
            }
        }
        remainingBalance = tcp - totalAmount;
        updatePaymentStatus();
    }

    private void updatePaymentStatus() {
        if (totalAmount == 0) {
            paymentStatus = "Not Started";
        } else if (totalAmount >= tcp) {
            paymentStatus = "Completed";
        } else {
            paymentStatus = "In Progress";
        }
    }

    public String getBuyer() { return buyer; }
    public String getProfession() { return profession; }
    public String getDateAcquired() { return dateAcquired; }
    public String getPaymentStatus() { return paymentStatus; }
    public int getLotNumber() { return lotNumber; }
    public int getBlockNumber() { return blockNumber; }
    public double getTcp() { return tcp; }
    public double getTotalAmount() { return totalAmount; }
    public double getRemainingBalance() { return remainingBalance; }
}
