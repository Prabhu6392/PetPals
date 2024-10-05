package dao;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, String itemType) {
        super(donorName, 0); 
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public void recordDonation() {
        
        System.out.println("Item Donation Recorded: " + itemType + " from " + getDonorName());
    }
}
