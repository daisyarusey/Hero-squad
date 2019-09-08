package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero= setupNewHero();
        assertTrue(String.valueOf(true),hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("Luke Cage", hero.getName());
    }
    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
       Hero hero = setupNewHero();
        assertEquals(30, hero.getAge());
    }

    @Test
    public void HeroInstantiatesWithPower_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("Bullet proof", hero.getPower());
    }

    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("emotional", hero.getWeakness());

    }

    @Test
    public void heroesInstantiateWithId() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(0, hero.getId());
    }




    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), hero.getCreatedAt().getDayOfWeek());
    }








    public Hero setupNewHero(){
        return new Hero("Luke Cage",30,"Bullet proof","emotional",1);
    }


}