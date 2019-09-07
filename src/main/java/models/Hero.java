package models;

public class Hero {
    private String name;
    public Hero(String name, int age, String power, String weakness) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
