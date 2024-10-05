package dao;

import java.util.ArrayList;
import java.util.List;

public abstract class Donation {
    private String donorName;
    private double amount;

   
    private static List<Donation> allDonations = new ArrayList<>();

    public Donation(String donorName, double amount) {
        this.donorName = donorName;
        this.amount = amount;
        allDonations.add(this);  
    }

    
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static List<Donation> getAllDonations() {
        return allDonations; 
    }


    public abstract void recordDonation();
}
