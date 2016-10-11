package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import org.hamcrest.Matcher;

public class CalculatorTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

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

    @Test
    public void testNewLine()
    {
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testOneNegativeNumber()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2");
    }

    @Test
    public void testMultipleNegativeNumbers()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negatives not allowed: -4,-5");
        Calculator.add("2,-4,3,-5");
    }

    @Test
    public void testBiggerThanThousand()
    {
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testChangeDelmiter()
    {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testMixingDelmiters()
    {
        assertEquals(55, Calculator.add("//;\n1;2,3\n4,5;6;7\n8,9;10"));
    }
}
