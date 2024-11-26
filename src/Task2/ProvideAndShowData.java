package Task2;

import InputHandling.InputHandling;
import java.util.ArrayList;
import java.util.Scanner;


public class ProvideAndShowData
{
    /*
    This method asks the user to enter city names and adds them to the cities list.
    */
    public void ProvideCitiesName(Scanner scanner, ArrayList<City> cities)
    {
        // Ask for the number of cities
        System.out.println("Enter an amount of cities:");
        int numberOfCities = InputHandling.ProvideAndCheckNaturalNumber(scanner);

        // Loop through and collect the name of each city
        for (int i = 0; i < numberOfCities; ++i)
        {
            System.out.println("Enter a name of the №" + (i + 1) + " city:");
            cities.add(new City(scanner.nextLine().trim()));
        }
    }

    /*
    This method asks the user for the connections (neighbors and cost) for each city
    and adds them to the respective city's connection list.
    */
    public void ProvideCitiesConnections(Scanner scanner, ArrayList<City> cities)
    {
        // Loop through each city to ask for its connections
        for (City city : cities)
        {
            System.out.println("Enter an amount of connections for "
                    + city.GetName() + ":");

            // Get the number of connections for the current city
            int numberOfConnections = InputHandling.ProvideAndCheckNaturalNumber(scanner), cost;
            City choosenCity;
            for (int j = 0; j < numberOfConnections; j++)
            {
                // Get the index of the connected city
                System.out.println("Enter a connection №" + (j + 1) + " (please provide index of the city):");
                choosenCity = cities.get(InputHandling.ProvideAndCheckNaturalNumber(scanner) - 1);  // Subtract 1 to get correct index

                // Get the cost for the connection
                System.out.println("Enter a cost of connection №" + (j + 1) + ":");
                cost = InputHandling.ProvideAndCheckNaturalNumber(scanner);

                city.AddConnection(choosenCity, cost);
            }
        }
    }

    /*
    This method asks the user to provide paths between cities for which we will calculate the cost.
    The cost of each path is stored in allCostes.
    */
    public void ProvidePath(Scanner scanner, ArrayList<City> cities, ArrayList<Integer> allCostes)
    {
        int index1, index2;

        // Ask how many paths the user wants to calculate
        System.out.println("Enter an amount of roads which you want to build:");
        int numberOfRoads = InputHandling.ProvideAndCheckNaturalNumber(scanner);

        // Loop through each requested path
        for (int i = 0; i < numberOfRoads; i++)
        {
            // Ask the user to enter the indexes of the two cities for the path
            System.out.println("Enter the indexes of the cities between which you want to build a road:");
            index1 = InputHandling.ProvideAndCheckNaturalNumber(scanner) - 1;  // Get the first city index
            System.out.println("Enter the second index:");
            index2 = InputHandling.ProvideAndCheckNaturalNumber(scanner) - 1;  // Get the second city index

            // Find the cheapest path between the two cities and add the cost to the list
            allCostes.add(cities.get(index1).FindWay(cities.get(index2)));
        }
    }

    /*
    This method displays the costs for all the paths the user requested.
    */
    public void ShowCost(ArrayList<Integer> allCostes)
    {
        // Loop through the list and print each cost
        for (int cost : allCostes) System.out.println("Cost = " + cost);
    }
}
