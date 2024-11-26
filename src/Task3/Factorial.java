package Task3;
import java.util.ArrayList;


public class Factorial
{
    private Integer number;


    // Function to multiply the current factorial with a number x
    private void Multiply(ArrayList<Integer> factorial, int x)
    {
        int carryOver = 0;

        for (int i = 0; i < factorial.size() || carryOver > 0; i++)
        {
            if (i == factorial.size())
            {
                // If we've processed all existing digits, add a new digit
                factorial.add(0);
            }

            long partialResult = (long) factorial.get(i) * x + carryOver;

            // Update the digit at the current position
            factorial.set(i, (int) (partialResult % 10));

            // Update the carryOver for the next position
            carryOver = (int) (partialResult / 10);
        }
    }

    public Factorial(Integer number_)
    {
        number = number_;
    }

    // Algorithm complexity = O(n * log(n))
    public int CountFactorialDigit()
    {
        // Initialize a list to store the factorial, starting with 1
        ArrayList<Integer> factorial = new ArrayList<>();
        factorial.add(1);

        for (int i = 2; i <= number; i++) Multiply(factorial, i);

        // Calculate the sum of digits in the factorial
        int sumOfDigits = 0;
        for (int digit : factorial) sumOfDigits += digit;

        return sumOfDigits;
    }
}
