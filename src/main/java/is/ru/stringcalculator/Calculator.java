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

            int sum = 0;

            for(String num : split)
            {
                sum += toInt(num);
            }

            return sum;
        }

        return toInt(numbers);
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}
