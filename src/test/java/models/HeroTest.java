package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        Hero hero = new Hero("Luke Cage",30,"Bullet proof","emotional");
        assertTrue(true);
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = new Hero("Luke Cage",30,"Bullet proof","emotional");
        assertEquals("Luke Cage", hero.getName());

    }
    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
        Hero hero = new Hero("Luke Cage", 30, "Bullet proof", "emotional");
        assertEquals(30, hero.getAge());
    }
}