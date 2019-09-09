package models;

import java.time.LocalDateTime;
import  java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private  String power;
    private  int age;
    private String name;
    private String weakness;
    private int id;
    private LocalDateTime createdAt;
    private int squadId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                Objects.equals(power, hero.power) &&
                Objects.equals(name, hero.name) &&
                Objects.equals(weakness, hero.weakness) &&
                Objects.equals(createdAt, hero.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, age, name, weakness, id, createdAt);
    }


    public Hero(String name, int age, String power, String weakness, int squadId) {
        this.name=name;
        this.age=age;
        this.power= power;
        this.weakness=weakness;
        this.createdAt = LocalDateTime.now();
        this.squadId = squadId;

    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
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



}
