import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Sql2oHeroDao;
import dao.Sql2oSquadDao;
import models.Hero;
import models.Squad;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);


        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/hero-squad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);
        Sql2oSquadDao squadDao = new Sql2oSquadDao(sql2o);

        //get: show all heroes in all squads and show all squads
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> allSquads =squadDao.getAll();
            modelAndView("squads", String.valueOf(allSquads));
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all heroes
        get("/heroes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            heroDao.clearAllHeroes();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual hero
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id"));
            heroDao.deleteById(idOfHeroToDelete);
            return new ModelAndView(model,"hero-list.hbs");

        }, new HandlebarsTemplateEngine());




        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroes-form.hbs");
        }, new HandlebarsTemplateEngine());
//
//        // process new hero form
        post("/heroes", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");;
            int age = Integer.parseInt(req.queryParams("age"));
            Hero newHero = new Hero(name,age,power,weakness,1);
            heroDao.add(newHero);
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes",heroes);

            return new ModelAndView(model,"hero-list.hbs");
        }, new HandlebarsTemplateEngine());




    get("/heroes",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        List<Hero> heroes = heroDao.getAll();
        model.put("heroes",heroes);
        return new ModelAndView(model, "hero-list.hbs");
    },new HandlebarsTemplateEngine());


        get("/heroes/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = heroDao.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "Heroes-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process a form to update a hero
        post("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            int newAge= Integer.parseInt(req.params("age"));

            String newPower=req.queryParams("power");
            String newWeakness=req.queryParams("weakness");;
            heroDao.update(idOfHeroToEdit, newName,newAge,newPower,newWeakness,1);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //show new squad form
        get("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squads = squadDao.getAll(); //refresh list of links for navbar
            model.put("squads", squads);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());


//post: process new squad form
        post("/squads", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int maxSize = Integer.parseInt(req.queryParams("maxSize"));
            String cause = req.queryParams("cause");
            Squad newSquad = new Squad(name,maxSize,cause);
            squadDao.add(newSquad);
            List<Squad> squads = squadDao.getAll();
            model.put("squads",squads);

            return new ModelAndView(model,"squad-list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squad = squadDao.getAll();
            model.put("squad",squad);
            return new ModelAndView(model, "squad-list.hbs");
        },new HandlebarsTemplateEngine());
    }
}
