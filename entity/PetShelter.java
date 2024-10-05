package entity;
import exception.NullReferenceException;
import exception.AdoptionException;
import java.util.ArrayList;
import java.util.List;

public class PetShelter implements IAdoptable{
    private List<Pet> availablePets;

    public PetShelter() {
        availablePets = new ArrayList<>();
    }

    public void addPet(Pet pet) throws NullReferenceException {
        if (pet == null) {
            throw new NullReferenceException("Pet cannot be null.");
        }
        availablePets.add(pet);
        System.out.println("Pet added to shelter: " + pet);
    }

    public void removePet(Pet pet) throws AdoptionException {
        if (pet == null || !availablePets.contains(pet)) {
            throw new AdoptionException("Pet not found in shelter.");
        }
        availablePets.remove(pet);
        System.out.println("Pet removed from shelter: " + pet);
    }

    public void listAvailablePets() {
        if (availablePets.isEmpty()) {
            System.out.println("No pets available for adoption.");
        } else {
            System.out.println("Available Pets:");
            for (Pet pet : availablePets) {
                System.out.println(pet);
            }
        }
    }
    @Override
    public void adopt() {
        if (availablePets.isEmpty()) {
            System.out.println("No pets available for adoption.");
        } else {
            System.out.println("Pets are being adopted!");
            availablePets.clear();  // Example of what might happen during adoption
        }
    }
    @Override
    public String toString() {
        return "PetShelter with " + availablePets.size() + " available pets.";
    }
    

    public List<Pet> getAvailablePets() {
        return availablePets;
    }
}

