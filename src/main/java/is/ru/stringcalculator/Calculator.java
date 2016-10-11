package is.ru.stringcalculator;

public class Calculator
{
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.contains(",") || numbers.contains("\n")){
            String[] split = numbers.split(",|\n");

            int sum = 0;

            for(String num : split)
            {
                int n = toInt(num);

                if(n < 0)
                {
                    throw new IllegalArgumentException("Negatives not allowed: " + num);
                }

                sum += n;
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
