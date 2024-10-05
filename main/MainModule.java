package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import entity.Pet;
import entity.Dog;
import entity.Cat;
import entity.PetShelter;
import dao.CashDonation;
import dao.DonationsManager;
import dao.ItemDonation;
import dao.Adoption;
import dao.AdoptionEvent;
import exception.InvalidPetAgeException;
import exception.NullReferenceException;
import exception.AdoptionException;
import exception.InsufficientFundsException;

public class MainModule {;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetShelter shelter = new PetShelter();
        AdoptionEvent adoptionEvent = new AdoptionEvent();

        while (true) {
            System.out.println("\n--- PetPals Menu ---");
            System.out.println("1. Add Pet");
            System.out.println("2. Remove Pet");
            System.out.println("3. List Available Pets");
            System.out.println("4. Make a Donation");
            System.out.println("5. View All Donations");
            System.out.println("6. Make Adoption Event");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            try {
                switch (choice) {
                    case 1:
                        addPet(scanner, shelter);
                        break;
                    case 2:
                        removePet(scanner, shelter);
                        break;
                    case 3:
                        shelter.listAvailablePets();
                        break;
                    case 4:
                        makeDonation(scanner);
                        break;
                    case 5:
                        DonationsManager.displayAllDonations();
                        break;
                    case 6:
                        createAdoptionEvent(scanner, shelter, adoptionEvent);
                        break;
                    case 7:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addPet(Scanner scanner, PetShelter shelter)
            throws InvalidPetAgeException, NullReferenceException {
        System.out.print("Enter Pet Type (Dog/Cat): ");
        String type = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Breed: ");
        String breed = scanner.nextLine();

        try{
            Pet pet;
            if (type.equalsIgnoreCase("Dog")) {
                Dog dog = new Dog(name, age, breed);
                shelter.addPet(dog);
            } else if (type.equalsIgnoreCase("Cat")) {
                System.out.print("Enter Color: ");
                String color = scanner.nextLine();
                Cat cat = new Cat(name, age, breed, color);
                shelter.addPet(cat);
            } else {
                System.out.println("Invalid pet type.");
            }
    
            System.out.print("Is this pet being adopted? (yes/no): ");
            String adopt = scanner.nextLine();
        } catch (InvalidPetAgeException e) {
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }
        

        

    private static void removePet(Scanner scanner, PetShelter shelter) throws AdoptionException {
        System.out.print("Enter Name of Pet to Remove: ");
        String name = scanner.nextLine();
        Pet petToRemove = null;
        for (Pet pet : shelter.getAvailablePets()) {
            if (pet.getName().equalsIgnoreCase(name)) {
                petToRemove = pet;
                break;
            }
        }
        if (petToRemove != null) {
            shelter.removePet(petToRemove);
        } else {
            throw new AdoptionException("Pet not found.");
        }
    }

    private static void makeDonation(Scanner scanner) throws InsufficientFundsException {
        System.out.print("Enter Donor Name: ");
        String donorName = scanner.nextLine();

        System.out.print("Enter Donation Type (Cash/Item): ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("Cash")) {
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            CashDonation cashDonation = new CashDonation(donorName, amount, new Date());
            cashDonation.recordDonation();
        } else if (type.equalsIgnoreCase("Item")) {
            System.out.print("Enter Item Type: ");
            String itemType = scanner.nextLine();
            ItemDonation itemDonation = new ItemDonation(donorName, itemType);
            itemDonation.recordDonation();
        } else {
            System.out.println("Invalid donation type.");
        }
    }
    private static void createAdoptionEvent(Scanner scanner, PetShelter shelter, AdoptionEvent event) {
        System.out.println("Creating an adoption event...");
        event.registerParticipant(shelter);
        for (Pet pet : shelter.getAvailablePets()) {
            event.registerParticipant(pet);
            System.out.println("Adoption Event Created! Hosting the event now...");
            event.hostEvent();}
}}