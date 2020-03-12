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
        int position = 0;
        //y: 1-3 DARKNORMAL expected
        //y: 6-8 LIGHTNORMAL expected
        Figure temp = new Figure(2,1,Figure.DARKNORMAL);
        assertEquals(temp.getX(), test.field.get(position).getX());
        assertEquals(temp.getY(), test.field.get(position).getY());
        assertEquals(temp.getState(), test.field.get(position).getState());

    }

    @Test
    public void removeFigureTest()
    {
        Game test = new Game();
        test.createFigures();
        //checking if every Figure is removeable
        for(int position = 0; position<test.field.size(); position++) {
            test.removeFigure(test.field.get(position));
            assertEquals(0, test.field.get(position).getX());
            assertEquals(0, test.field.get(position).getY());
            assertEquals(0, test.field.get(position).getState());
        }
    }

    @Test
    public void isOnFieldTest()
    {
        Game test = new Game();
        test.createFigures();
        Figure temp = new Figure(0,0,0);
        for(int position =0;position<test.field.size(); position++) {
            temp = test.field.get(position);
            assertEquals(temp, test.isOnField(temp.getX(),temp.getY()));
        }
    }

    @Test
    public void moveFigureTest()
    {
        Game test = new Game();
        test.createFigures();

    }
    @Test
    public void DirectionOfFigureTest()
    {
        Game test = new Game();
        test.createFigures();
        int x=0;
        int y=0;
     //   test.directionOfFigure(test.field.get(1), test.field);
    }


}