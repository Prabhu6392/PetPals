package dao;

import java.util.Date;
import java.util.List;

public class Adoption {
    private List<String> adoptedPets; 
    private String adopterName;        
    private Date adoptionDate;         
    public Adoption(String adopterName, List<String> adoptedPets, Date adoptionDate) {
        this.adopterName = adopterName;
        this.adoptedPets = adoptedPets;
        this.adoptionDate = adoptionDate;
    }

    // Getters and Setters
    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public List<String> getAdoptedPets() {
        return adoptedPets;
    }

    public void setAdoptedPets(List<String> adoptedPets) {
        this.adoptedPets = adoptedPets;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    @Override
    public String toString() {
        return "Adoption [Adopter=" + adopterName + ", Pets=" + adoptedPets + ", Date=" + adoptionDate + "]";
    }
}
