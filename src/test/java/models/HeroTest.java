package models;

import jdk.internal.jline.internal.ShutdownHooks;
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
        Hero.clearAllHeroes();;
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
        assertEquals(1, hero.getId());
    }

    @Test
    public void AllHeroAreCorrectlyReturned_true() {
        Hero hero = setupNewHero();
        Hero otherHero = new Hero ("Iron Fist",24,"glowing hand","Weak");
        assertEquals(2, Hero.getAll().size());
    }
    @Test
    public void AllHeroReturnAllInstances_ofHero_true() {
        Hero hero = setupNewHero();
        Hero otherHero = new Hero ("Iron Fist",24,"glowing hand","Weak");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), hero.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero hero = setupNewHero();
        Hero otherHero = new Hero("Iron Fist",24,"glowing hand","Weak");
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }

    @Test
    public void deleteDeletesASpecificTask() throws Exception {
        Hero hero = setupNewHero();
        Hero otherHero = new Hero("Iron Fist",24,"glowing hand","Weak");
        hero.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(), 2);
    }

    @Test
    public void deleteAllTasksDeletesAllTasks() throws Exception {
        Hero hero = setupNewHero();
        Hero otherHero = setupNewHero();
        Hero.clearAllHeroes();
        assertEquals(0, Hero.getAll().size());
    }

    public Hero setupNewHero(){
        return new Hero("Luke Cage",30,"Bullet proof","emotional");
    }


}