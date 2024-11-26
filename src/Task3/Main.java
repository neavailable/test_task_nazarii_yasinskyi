package Task3;


public class Main
{
    public static void main(String[] args)
    {
        final int factorialNumber = 100;

        // creating a factorial object and pass there 100
        Factorial factorial = new Factorial(factorialNumber);

        System.out.println("Sum of digit of " + factorialNumber + "! = " + factorial.CountFactorialDigit());
    }
}