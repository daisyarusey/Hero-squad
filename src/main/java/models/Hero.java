package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {
    private  String power;
    private  int age;
    private String name;
    private String weakness;
    private int id;
    private LocalDateTime createdAt;

    public Hero(String name, int age, String power, String weakness) {
        this.name=name;
        this.age=age;
        this.power= power;
        this.weakness=weakness;
        this.createdAt = LocalDateTime.now();

    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }


    public String getPower() {
        return power;
    }

    public String getWeakness() {
        
        return weakness;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    


    public void update(String newContent) {
    }
}
