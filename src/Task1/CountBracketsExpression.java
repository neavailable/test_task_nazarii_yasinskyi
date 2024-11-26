package Task1;

import java.util.ArrayList;


public class CountBracketsExpression
{
    private ArrayList<String> current;
    private Integer countBrackets;

    public CountBracketsExpression(int countBrackets_)
    {
        // Initialize the current list with a single pair of brackets
        current = new ArrayList<>();
        current.add("()");

        countBrackets = countBrackets_;
    }

    // Method to count and generate all valid bracket expressions
    public void Count()
    {
        ArrayList<String> newList;
        String temp;

        // Loop to generate bracket expressions for the given number of pairs
        for (int i = 1; i < countBrackets; ++i)
        {
            newList = new ArrayList<>();

            for (String str : current)
            {
                // Insert "()" at every possible position in the current expression
                for (int j = 0; j < str.length(); j++)
                {
                    // Create a new bracket expression by adding "()" at position j
                    temp = str.substring(0, j) + "()" + str.substring(j);

                    // If the new expression is not already in the list, add it
                    if (newList.contains(temp)) continue;

                    newList.add(temp);
                }
            }

            // Update the current list with the new list of bracket expressions
            current = newList;
        }

        System.out.println("Brackets expressions = " + current.size());
    }
}