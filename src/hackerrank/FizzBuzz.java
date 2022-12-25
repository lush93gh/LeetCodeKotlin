package hackerrank;

public class FizzBuzz {
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            print(i);
        }
    }

    private static void print(int n) {
        var is3 = n % 3 == 0;
        var is5 = n % 5 == 0;
        if (is3 && is5) System.out.println("hackerrank.FizzBuzz");
        else if (is3) System.out.println("Fizz");
        else if (is5) System.out.println("Buzz");
        else System.out.println(n);
    }
}
