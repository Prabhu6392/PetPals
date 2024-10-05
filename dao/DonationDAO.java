package dao;

import java.io.IOException;
import util.DBConnUtil;
import java.sql.*;

public class DonationDAO {
    public void recordDonation(Donation donation) {
        String sql = "INSERT INTO donations (donor_name, amount) VALUES (?, ?)";
        
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, donation.getDonorName());
            pstmt.setDouble(2, donation.getAmount());
            pstmt.executeUpdate();
            System.out.println("Donation recorded: $" + donation.getAmount() + " from " + donation.getDonorName());
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error recording donation: " + e.getMessage());
        }
    }
}
