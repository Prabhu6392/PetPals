package entity;
import exception.InvalidPetAgeException;
public class Pet implements IAdoptable {
    private String name;
    private int age;
    private String breed;

    public Pet(String name, int age, String breed) throws InvalidPetAgeException {
        if (age <= 0) {
            throw new InvalidPetAgeException("Age must be positive.");
        }
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidPetAgeException {
        if (age <= 0) {
            throw new InvalidPetAgeException("Age must be positive.");
        }
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Implement the adopt() method from the IAdoptable interface
    @Override
    public void adopt() {
        System.out.println(name + " has been adopted!");
    }

    @Override
    public String toString() {
        return "Pet [Name=" + name + ", Age=" + age + ", Breed=" + breed + "]";
    }
}
