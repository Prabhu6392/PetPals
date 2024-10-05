package dao;

public class DonationsManager {
    public static void displayAllDonations() {
        System.out.println("All Donations:");
        if (Donation.getAllDonations().isEmpty()) {
            System.out.println("No donations recorded.");
            return;
        }

        for (Donation donation : Donation.getAllDonations()) {
            String type = donation instanceof CashDonation ? "Cash" : "Item"; // Determine donation type
            System.out.printf("%s Donation: $%.2f from %s%n", type, donation.getAmount(), donation.getDonorName());
        }
    }
}
