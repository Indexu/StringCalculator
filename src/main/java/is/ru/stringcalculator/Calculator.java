package is.ru.stringcalculator;

public class Calculator
{
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.contains(",")){
            String[] split = numbers.split(",");

            return toInt(split[0]) + toInt(split[1]);
        }

        return toInt(numbers);
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}
