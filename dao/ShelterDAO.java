package dao;

import entity.Pet;
import exception.InvalidPetAgeException;
import entity.Dog;
import entity.Cat;
import util.DBConnUtil;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShelterDAO {
    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, age, breed) VALUES (?, ?, ?)";
        
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pet.getName());
            pstmt.setInt(2, pet.getAge());
            pstmt.setString(3, pet.getBreed());
            pstmt.executeUpdate();
            System.out.println("Pet added to shelter: " + pet);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }

    public List<Pet> listAvailablePets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";

        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String breed = rs.getString("breed");

                try {
                    pets.add(new Pet(name, age, breed)); 
                } catch (InvalidPetAgeException e) {
                    System.out.println("Error adding pet from database: " + e.getMessage());
                }
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error retrieving pets: " + e.getMessage());
        }

        return pets;
    }
}
