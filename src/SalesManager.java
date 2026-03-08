public class SalesManager {
    
    private String managerName;

    public SalesManager(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void reserveLot(Lot lot, Buyer buyer) {

        if(lot.getStatus().equals("Available")) {

            lot.reserveLot(buyer);
            System.out.println("Lot " + lot.getLotNumber() + " reserved for " + buyer.getName());

        } 
        else {
            System.out.println("Lot " + lot.getLotNumber() + " is not available for reservation.");
        }
    }

    public void sellLot(Lot lot, Buyer buyer) {

        if(!lot.getStatus().equals("Sold")) {

            lot.sellLot(buyer);
            System.out.println(
                "Lot " + lot.getLotNumber() + " sold to " + buyer.getName() +
                " (Manager: " + managerName + ")"
            );

        }

        else {
            System.out.println("Lot " + lot.getLotNumber() + " is already sold.");
        }
    }

}
