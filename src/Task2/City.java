package Task2;

import java.util.*;


public class City
{
    private final String name;
    private final HashMap<City, Integer> connections;

    private class WayFounder
    {
        // Start and destination cities for finding the path
        private final City city1, city2;
        // Cost of the cheapest path
        private Integer cost;


        /*
        Helper method to reconstruct and remember the cheapest path.
        It backtracks from the destination city using the 'previous' map.
        previous - A map that stores the predecessor of each city in the path
        endCity  - The destination city where the path ends
        */
        public WayFounder(City city1_, City city2_)
        {
            city1 = city1_;
            city2 = city2_;
        }

        // Dijkstra algorithm finding the cheapest path
        public void FindWay()
        {
            // is pq a PriorityQueue to store cities to be processed, ordered by the current path cost
            PriorityQueue<Map.Entry<City, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
            // distances is a Map to store the shortest known distance to each city
            Map<City, Integer> distances = new HashMap<>();
            // previous is a Map to keep track of the predecessor of each city in the cheapest path
            Map<City, City> previous = new HashMap<>();
            // Set to track which cities have already been visited
            Set<City> visited = new HashSet<>();

            distances.put(city1, 0);
            pq.add(new AbstractMap.SimpleEntry<>(city1, 0));

            while (!pq.isEmpty()) {
                // Get the cheapest city
                Map.Entry<City, Integer> currentAll = pq.poll();
                City currentCity = currentAll.getKey();
                Integer currentCost = currentAll.getValue();

                // Skip the city if it has already been visited
                if (visited.contains(currentCity)) continue;

                // Mark the city as a visited
                visited.add(currentCity);

                // If we have reached the destination city
                if (currentCity == city2)
                {
                    cost = distances.get(city2);
                    return;
                }

                for (Map.Entry<City, Integer> neighborEntry : currentCity.connections.entrySet())
                {
                    City neighbor = neighborEntry.getKey();
                    int edgeCost = neighborEntry.getValue();
                    int newCost = currentCost + edgeCost;

                    // If we found a cheaper way
                    if (newCost < distances.getOrDefault(neighbor, Integer.MAX_VALUE))
                    {
                        distances.put(neighbor, newCost);
                        previous.put(neighbor, currentCity);

                        pq.add(new AbstractMap.SimpleEntry<>(neighbor, newCost));
                    }
                }
            }

            System.out.println("Way does not exist");
        }

        public int GetCost()
        {
            return cost;
        }
    }


    public City(String name_)
    {
        name = name_;
        connections = new HashMap<>();
    }

    public void AddConnection(City city, Integer cost)
    {
        connections.put(city, cost);
    }

    public int FindWay(City city)
    {
        WayFounder wayFounder = new WayFounder(this, city);
        wayFounder.FindWay();
        return wayFounder.GetCost();
    }

    public String GetName()
    {
        return name;
    }
}
