package entity;

import exception.InvalidPetAgeException;
import exception.NullReferenceException;

public class Cat extends Pet {
    private String catColor;

    public Cat(String name, int age, String breed, String catColor) throws InvalidPetAgeException, NullReferenceException {
        super(name, age, breed);
        if (catColor == null || catColor.isEmpty()) {
            throw new NullReferenceException("Cat color cannot be null or empty.");
        }
        this.catColor = catColor;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) throws NullReferenceException {
        if (catColor == null || catColor.isEmpty()) {
            throw new NullReferenceException("Cat color cannot be null or empty.");
        }
        this.catColor = catColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", CatColor=" + catColor;
    }
}
