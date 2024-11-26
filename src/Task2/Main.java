package Task2;

import java.util.ArrayList;
import java.util.Scanner;
import InputHandling.InputHandling;


public class Main
{
    /*
    This is the main loop that handles the full process for a single test case.
    It will prompt the user to provide city names, connections, and paths to calculate the costs.
    */
    private static void RunMainLoop(Scanner scanner)
    {
        ArrayList<City> cities = new ArrayList<>();  // List to hold cities
        ProvideAndShowData provideAndShowData = new ProvideAndShowData();

        provideAndShowData.ProvideCitiesName(scanner, cities);  // Ask for city names

        provideAndShowData.ProvideCitiesConnections(scanner, cities);  // Ask for connections between cities

        ArrayList<Integer> allCostes = new ArrayList<>();  // List to store path costs

        provideAndShowData.ProvidePath(scanner, cities, allCostes);  // Ask for paths to calculate and store costs

        provideAndShowData.ShowCost(allCostes);  // Display the calculated costs
    }

    /*
    The main method asks the user for the number of test cases and runs the main loop for each test case.
    */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of test cases
        System.out.println("Enter an amount of tests:");

        // numberOfTests is an integer and >0, so we use ProvideAndCheckNaturalNumber to validate the input
        int numberOfTests = InputHandling.ProvideAndCheckNaturalNumber(scanner);

        // Run the main loop for the specified number of test cases
        for (int i = 0; i < numberOfTests; i++) RunMainLoop(scanner);

        scanner.close();  // Close the scanner after usage
    }
}
