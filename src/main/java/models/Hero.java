package models;

public class Hero {
    private  int age;
    private String name;

    public Hero(String name, int age, String power, String weakness) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
