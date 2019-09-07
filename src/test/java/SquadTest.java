import models.Squad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void squad_instantiates_Correctly_true(){
        Squad squad = new Squad("Inked Sisters","Ladies riding motorcycles",12);
        assertTrue(squad instanceof Squad);
    }
}