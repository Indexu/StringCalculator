package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void testEmptyString()
    {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber()
    {
        assertEquals(5, Calculator.add("5"));
    }

    @Test
    public void testTwoNumbers()
    {
        assertEquals(10, Calculator.add("7,3"));
    }

    @Test
    public void testThreeNumbers()
    {
        assertEquals(13, Calculator.add("2,5,6"));
    }

    @Test
    public void testFourNumbers()
    {
        assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    public void testFiveNumbers()
    {
        assertEquals(35, Calculator.add("9,8,7,6,5"));
    }
}
