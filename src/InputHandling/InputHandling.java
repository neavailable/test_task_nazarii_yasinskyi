package InputHandling;

import java.util.Scanner;


public class InputHandling
{
    /*
    This method returns a natural integer greater than 0 and prevents incorrect user input
    (like a non-integer number, number less than or equal to 0, or a string).
    */
    public static Integer ProvideAndCheckNaturalNumber(Scanner scanner)
    {
        int number = -1;

        // Loop until the user provides valid input
        while (true)
        {
            // Get input from the user as a string
            String input = scanner.nextLine().trim();
            try
            {
                // Try parsing the input as a double
                double temp = Double.parseDouble(input);

                // Check if the number is a whole number (integer)
                if (temp % 1 != 0)
                {
                    System.out.println("You entered a decimal number. Please enter a whole number.");
                    continue;
                }

                // Convert the double to an integer because we know it's a whole number
                number = (int) temp;

                // Ensure the number is greater than 0
                if (number <= 0)
                {
                    System.out.println("The number must be greater than 0. Try again.");
                    continue;
                }
                break;  // If everything is valid, exit the loop
            }
            catch (NumberFormatException e)
            {
                // If we cannot parse the input as a number, print an error message
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return number;  // Return the valid number
    }
}