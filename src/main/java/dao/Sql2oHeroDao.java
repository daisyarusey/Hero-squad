package dao;

import models.Hero;
import org.sql2o.*;
import java.util.List;

public class Sql2oHeroDao implements HeroDao {

    private final Sql2o sql2o;

    public Sql2oHeroDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Hero hero) {
        String sql = "INSERT INTO heroes (name,age,power,weakness,squadId) VALUES (:name,:age,:power,:weakness,:squadId)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(hero)
                    .executeUpdate()
                    .getKey();//int id is now the row number (row “key”) of db
            hero.setId(id); //update object to set id now from database
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<Hero> getAll() {
        try (Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM heroes")
                    .executeAndFetch(Hero.class);
        }
    }


    @Override
    public Hero findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Hero.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newName, int newAge, String newPower, String newWeakness,int newSquadId){
        String sql = "UPDATE heroes SET name = :name, age= :age, power=:power,weakness=:weakness,squadId=:squadId WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("age",newAge)
                    .addParameter("power",newPower)
                    .addParameter("weakness",newWeakness)
                    .addParameter("squadId",newSquadId)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from heroes WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllHeroes() {
        String sql = "DELETE from heroes";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
