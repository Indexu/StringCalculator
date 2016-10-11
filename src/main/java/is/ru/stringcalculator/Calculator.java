package is.ru.stringcalculator;

import java.util.ArrayList;

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
            int[] nums = toInt(split);

            checkForNegatives(nums);
            
            return sumArray(nums);
        }

        return toInt(numbers);
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

            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
    }

    private static int sumArray(int[] nums)
    {
        int sum = 0;

        for(int num : nums)
        {
            sum += num;
        }

        return sum;
    }
}
