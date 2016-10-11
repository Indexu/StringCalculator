package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator
{
    private static final String negativeMessage = "Negatives not allowed: ";
    private static final int maxNumber = 1000;
    private static String delim = ",|\\n";

    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }

        if(numbers.contains("//"))
        {
            delim = delim + "|" + numbers.substring(2,3);
            numbers = numbers.substring(4);
        }

        String[] split = numbers.split(delim);
        int[] nums = toInt(split);

        checkForNegatives(nums);

        return sumArray(nums);
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }

    private static int[] toInt(String[] numbers)
    {
        int[] arr = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++)
        {
            arr[i] = toInt(numbers[i]);
        }

        return arr;
    }

    private static void checkForNegatives(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num : nums)
        {
            if(num < 0)
            {
                list.add(num);
            }
        }

        if(list.size() != 0)
        {
            String negatives = "";

            for(int num : list)
            {
                negatives += num;

                if(num != list.get(list.size()-1))
                {
                    negatives += ",";
                }
            }

            throw new IllegalArgumentException(negativeMessage + negatives);
        }
    }

    private static int sumArray(int[] nums)
    {
        int sum = 0;

        for(int num : nums)
        {
            if(num <= maxNumber)
            {
                sum += num;
            }
        }

        return sum;
    }
}
