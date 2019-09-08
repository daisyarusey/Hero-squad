package dao;

import models.Hero;

import java.util.List;

public interface HeroDao {
    // LIST
    List<Hero> getAll();

    // CREATE
    void add(Hero hero) ;

    // READ
    Hero findById(int id);


    // UPDATE
    void update(int id, String name, int age, String power, String weakness);

    // DELETE


    void deleteById(int id);

    void clearAllHeroes();
}
