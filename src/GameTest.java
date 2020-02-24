import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void createFigureTest_rightAmountOfFigures()
    {
        Game test = new Game();
        test.createFigures();
        assertEquals(24, test.field.size());

    }

}