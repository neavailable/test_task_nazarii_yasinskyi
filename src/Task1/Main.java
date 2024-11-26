package Task1;

import InputHandling.InputHandling;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of brackets:");

        // Get the number of brackets from the user and check if it's a natural number
        int countBrackets = InputHandling.ProvideAndCheckNaturalNumber(scanner);

        // Create a CountBracketsExpression object and calculate the bracket expressions
        (new CountBracketsExpression(countBrackets)).Count();

        scanner.close();
    }
}