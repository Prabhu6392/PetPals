package entity;

import exception.InvalidPetAgeException;
import exception.NullReferenceException;

public class Dog extends Pet {
    private String dogBreed;

    public Dog(String name, int age, String dogBreed) throws InvalidPetAgeException, NullReferenceException {
        super(name, age, dogBreed);
        this.dogBreed = dogBreed;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) throws NullReferenceException {
        if (dogBreed == null || dogBreed.isEmpty()) {
            throw new NullReferenceException("Dog breed cannot be null or empty.");
        }
        this.dogBreed = dogBreed;
    }

    @Override
    public String toString() {
        return super.toString() + ", DogBreed=" + dogBreed;
    }
}
