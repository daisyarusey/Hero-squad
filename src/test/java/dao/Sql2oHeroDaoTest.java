package dao;

import models.Hero;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
public class Sql2oHeroDaoTest {
    private Sql2oHeroDao heroDao; //ignore me for now. We'll create this soon.
    private Connection conn; //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        heroDao = new Sql2oHeroDao(sql2o); //ignore me for now
        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingCourseSetsId() throws Exception {
        Hero hero = new Hero ("Iron Fist",37,"glowing hand","weak");
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId()); //how does this work?
    }

    @Test
    public void existingHeroesCanBeFoundById() throws Exception {
        Hero hero = new Hero ("Iron Fist",37,"glowing hand","weak");
        heroDao.add(hero); //add to dao (takes care of saving)
        Hero foundHero = heroDao.findById(hero.getId()); //retrieve
        assertEquals(hero, foundHero); //should be the same
    }


}
