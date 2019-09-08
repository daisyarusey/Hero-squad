package dao;
import models.Squad;
import models.Hero;

import java.util.List;

public interface SquadDao {
    //LIST
    List<Squad> getAll();

    //CREATE
    void add (Squad squad);

    //READ
    Squad findById(int id);

    //UPDATE
    void update(int id, String name,int maxSize, String cause);

    //DELETE
    void deleteById(int id);
    void clearAllSquads();
}
