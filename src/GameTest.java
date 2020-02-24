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

    @Test
    public void createFigureTest_goodCoordinate()
    {
        Game test = new Game();
        test.createFigures();
        int position = 2;
        Figure temp = new Figure(6,1,Figure.DARKNORMAL);
        assertEquals(temp.getX(), test.field.get(position).getX());
        assertEquals(temp.getY(), test.field.get(position).getY());
        assertEquals(temp.getState(), test.field.get(position).getState());
        //assertEquals(new Figure(4,1,Figure.DARKNORMAL), test.field.get(2));
        //assertEquals(new Figure(1,6,Figure.LIGHTNORMAL), test.field.get(13));
        //assertEquals(new Figure(3,6,Figure.LIGHTNORMAL), test.field.get(14))
    }

}