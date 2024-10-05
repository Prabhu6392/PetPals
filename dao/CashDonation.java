package dao;

import java.util.Date;
import exception.InsufficientFundsException;

public class CashDonation extends Donation {
    private Date donationDate;

    public CashDonation(String donorName, double amount, Date donationDate) throws InsufficientFundsException {
        super(donorName, amount);
        if (amount < 10) {
            throw new InsufficientFundsException("Minimum donation amount is $10.");
        }
        this.donationDate = donationDate;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public void recordDonation() {
        // Logic to record the donation (e.g., save to database)
        System.out.println("Cash Donation Recorded: $" + getAmount() + " from " + getDonorName());
    }
}
